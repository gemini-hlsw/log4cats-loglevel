package log4cats.loglevel

import scala.annotation.tailrec

// Shamelessly copied and slightly adapted from https://github.com/Log4s/log4s/blob/master/core/js/src/main/scala/org/log4s/log4sjs/MessageFormatter.scala. Thank you.
trait ThrowableFormatter {
  def apply(t: Throwable)(message: => String): String
}

class StandardThrowableFormatter(
  val useLocalizedThrowableMessages: Boolean = false
) extends ThrowableFormatter {
  private[this] final val indentSize   = 8
  private[this] final val indentString = " " * indentSize

  def apply(t: Throwable)(message: => String): String =
    s"$message:\n${renderStackTrace(t)}"

  protected[this] def renderStackTrace(t: Throwable): String =
    (t +: unfoldCauses(t)).map(renderOneStack).mkString("Caused by: ")

  protected[this] def renderOneStack(t: Throwable): String = {
    val className = t.getClass.getName
    val message   = if (useLocalizedThrowableMessages) t.getLocalizedMessage else t.getMessage
    val stack     = {
      val frames = t.getStackTrace
      frames.flatMap { frame =>
        val basicInfo    = Vector(indentString, "at ", frame.getClassName, ".", frame.getMethodName)
        val positionInfo =
          Option(frame.getFileName)
            .map { fn =>
              val linePart =
                frame.getLineNumber match {
                  case n if n < 0 => Nil
                  case other      => Seq(":", other.toString)
                }
              "(" +: fn +: linePart :+ ")"
            }
            .toSeq
            .flatten
        (basicInfo ++ positionInfo :+ "\n")
      }
    }
    s"$className: $message\n${stack.mkString}"
  }

  private[this] def unfoldCauses(t: Throwable): Seq[Throwable] = {
    def unfold[A, B](b: B)(fn: B => Option[(A, B)]): Seq[A] = {
      @tailrec def helper(b: B, accum: Vector[A]): Seq[A] =
        fn(b) match {
          case Some((a, b2)) => helper(b2, accum :+ a)
          case None          => accum
        }
      helper(b, Vector.empty)
    }
    unfold(t)(thr => Option(thr.getCause).map(c => (c, c)))
  }
}
