package com.decaf.money

final case class Stock(
  name: String,
  company: Company,
  shares: BigInt,
  askingPrice: Money
) {
  final def canAffordPurchase(shares: BigInt, payment: Money)(implicit conv: CurrencyConversion[payment.currency.type, askingPrice.currency.type]) =
    payment.convertToForeignCurrency(conv).units < askingPrice.units
}
