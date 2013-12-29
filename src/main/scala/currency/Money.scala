package com.decaf.money

final case class Money (
  currency: Currency,
  units: BigDecimal
) {
  final def convertToForeignCurrency[To <: Currency](conv: CurrencyConversion[currency.type, To]) =
    CurrencyConversion(this)(conv)
}
