package org.scalablytyped.runtime

import scala.scalajs.js

@js.native
trait TopLevel[T] extends js.Any

object TopLevel {
  @inline implicit def asT[T](t: TopLevel[T]): T = t.asInstanceOf[T]
}
