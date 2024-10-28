// Copyright (c) 2016-2023 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package log4cats.loglevel

import cats.effect.Sync
import org.typelevel.log4cats.SelfAwareLogger
import typings.loglevel.loglevelNumbers._
import typings.loglevel.mod.LogLevelDesc
import typings.loglevel.mod.LogLevelNumbers
import typings.loglevel.mod.^
import typings.loglevel.mod.{Logger => Base}

object LogLevelLogger {
  type Level = LogLevelNumbers

  private val levelNumbersOrder: Map[LogLevelNumbers, Int] =
    List(`0`, `1`, `2`, `3`, `4`, `5`).zipWithIndex.toMap

  implicit private val levelNumbersOrdering: Ordering[Level] =
    Ordering.by(levelNumbersOrder)
  import levelNumbersOrdering._

  private val throwableFormatter = new StandardThrowableFormatter()

  val Level = LogLevelDesc

  def setLevel(level:        LogLevelDesc): Unit = ^.setLevel(level)
  def setDefaultLevel(level: LogLevelDesc): Unit = ^.setDefaultLevel(level)
  def disableAll(): Unit                         = ^.disableAll()
  def enableAll(): Unit                          = ^.enableAll()
  def getLevel: Level                            = ^.getLevel().asInstanceOf[Level]

  def createForRoot[F[_]: Sync]                  = fromLogLevel[F](^)
  def createByName[F[_]: Sync](name:   String)   = fromLogLevel[F](^.getLogger(name))
  def createByClass[F[_]: Sync](clazz: Class[?]) = fromLogLevel[F](^.getLogger(clazz.getName))

  def fromLogLevel[F[_]: Sync](logger: Base): SelfAwareLogger[F] =
    new SelfAwareLogger[F] {
      // TRACE: 0;
      // DEBUG: 1;
      // INFO: 2;
      // WARN: 3;
      // ERROR: 4;
      // SILENT: 5;

      override def isTraceEnabled: F[Boolean] = Sync[F].delay(getLevel >= `0`)

      override def isDebugEnabled: F[Boolean] = Sync[F].delay(getLevel >= `1`)

      override def isInfoEnabled: F[Boolean] = Sync[F].delay(getLevel >= `2`)

      override def isWarnEnabled: F[Boolean] = Sync[F].delay(getLevel >= `3`)

      override def isErrorEnabled: F[Boolean] = Sync[F].delay(getLevel >= `4`)

      override def error(message: => String): F[Unit] = Sync[F].delay(logger.error(message))

      override def warn(message: => String): F[Unit] = Sync[F].delay(logger.warn(message))

      override def info(message: => String): F[Unit] = Sync[F].delay(logger.info(message))

      override def debug(message: => String): F[Unit] = Sync[F].delay(logger.debug(message))

      override def trace(message: => String): F[Unit] = Sync[F].delay(logger.trace(message))

      override def error(t: Throwable)(message: => String): F[Unit] =
        error(throwableFormatter(t)(message))

      override def warn(t: Throwable)(message: => String): F[Unit] =
        warn(throwableFormatter(t)(message))

      override def info(t: Throwable)(message: => String): F[Unit] =
        info(throwableFormatter(t)(message))

      override def debug(t: Throwable)(message: => String): F[Unit] =
        debug(throwableFormatter(t)(message))

      override def trace(t: Throwable)(message: => String): F[Unit] =
        trace(throwableFormatter(t)(message))

    }
}
