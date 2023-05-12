// Copyright (c) 2016-2023 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package typings.loglevel.mod

import typings.loglevel.loglevelNumbers.`0`
import typings.loglevel.loglevelNumbers.`1`
import typings.loglevel.loglevelNumbers.`2`
import typings.loglevel.loglevelNumbers.`3`
import typings.loglevel.loglevelNumbers.`4`
import typings.loglevel.loglevelNumbers.`5`

import scala.scalajs.js

/**
 * Log levels
 */
@js.native
trait LogLevel extends js.Object {
  var DEBUG: `1`  = js.native
  var ERROR: `4`  = js.native
  var INFO: `2`   = js.native
  var SILENT: `5` = js.native
  var TRACE: `0`  = js.native
  var WARN: `3`   = js.native
}

object LogLevel {
  @scala.inline
  def apply(DEBUG: `1`, ERROR: `4`, INFO: `2`, SILENT: `5`, TRACE: `0`, WARN: `3`): LogLevel = {
    val __obj = js.Dynamic.literal(
      DEBUG = DEBUG.asInstanceOf[js.Any],
      ERROR = ERROR.asInstanceOf[js.Any],
      INFO = INFO.asInstanceOf[js.Any],
      SILENT = SILENT.asInstanceOf[js.Any],
      TRACE = TRACE.asInstanceOf[js.Any],
      WARN = WARN.asInstanceOf[js.Any]
    )

    __obj.asInstanceOf[LogLevel]
  }
}
