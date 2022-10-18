// Copyright (c) 2016-2022 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package typings.loglevel

import scala.scalajs.js

package object mod {
  type LoggingMethod = js.Function1[ /* repeated */ js.Any, scala.Unit]
  type MethodFactory = js.Function3[
    /* methodName */ java.lang.String,
    /* level */ typings.loglevel.mod.LogLevelNumbers,
    /* loggerName */ java.lang.String,
    typings.loglevel.mod.LoggingMethod
  ]
}
