package com.decaf.money

abstract class CurrencyConversion[From <: Currency, To <: Currency] {
  def ratio: BigDecimal
}

object CurrencyConversion {
  def apply[To <: Currency](amt: Money)(implicit conv: CurrencyConversion[amt.currency.type, To]) =
    Money(amt.currency, conv.ratio * amt.units)

  implicit def IdentityCurrencyConversion[C <: Currency] = new CurrencyConversion[C, C] {
    lazy val ratio = BigDecimal(1)
  }
}
