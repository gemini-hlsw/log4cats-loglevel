// Copyright (c) 2016-2022 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package org.scalablytyped.runtime

import scala.scalajs.js

@js.native
trait TopLevel[T] extends js.Any

object TopLevel {
  @inline implicit def asT[T](t: TopLevel[T]): T = t.asInstanceOf[T]
}
