// Copyright (c) 2016-2022 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package org.scalablytyped.runtime

import scala.scalajs.js
import scala.scalajs.js.WrappedDictionary

trait StringDictionary[+V] extends js.Object

object StringDictionary {

  /** Returns a new empty dictionary */
  @inline def empty[A]: StringDictionary[A] =
    (new js.Object).asInstanceOf[StringDictionary[A]]

  @inline
  def apply[A](properties: (String, A)*): StringDictionary[A] = {
//      js.special.objectLiteral(properties: _*).asInstanceOf[StringDictionary[A]]

    val result = empty[A]
    for ((key, value) <- properties)
      result(key) = value
    result
  }

  @inline implicit def wrapStringDictionary[V](dict: StringDictionary[V]): WrappedDictionary[V] =
    new WrappedDictionary(dict.asInstanceOf[js.Dictionary[V]])
}
