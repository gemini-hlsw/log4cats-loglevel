// Copyright (c) 2016-2023 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package typings.loglevel

import typings.loglevel.mod.LogLevelNumbers

import scala.scalajs.js

object loglevelNumbers {
  @js.native
  sealed trait `0` extends LogLevelNumbers

  @js.native
  sealed trait `1` extends LogLevelNumbers

  @js.native
  sealed trait `2` extends LogLevelNumbers

  @js.native
  sealed trait `3` extends LogLevelNumbers

  @js.native
  sealed trait `4` extends LogLevelNumbers

  @js.native
  sealed trait `5` extends LogLevelNumbers

  @scala.inline
  def `0`: `0` = 0.asInstanceOf[`0`]
  @scala.inline
  def `1`: `1` = 1.asInstanceOf[`1`]
  @scala.inline
  def `2`: `2` = 2.asInstanceOf[`2`]
  @scala.inline
  def `3`: `3` = 3.asInstanceOf[`3`]
  @scala.inline
  def `4`: `4` = 4.asInstanceOf[`4`]
  @scala.inline
  def `5`: `5` = 5.asInstanceOf[`5`]
}
