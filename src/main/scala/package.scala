package com.decaf

package object money {
  type DateTime = org.joda.time.DateTime
  def now = org.joda.time.DateTime.now
}
