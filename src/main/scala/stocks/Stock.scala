package com.decaf.money

final case class Stock(
  name: String,
  company: Company,
  shares: BigInt,
  askingPrice: Money
) {
  final def canAffordPurchase(shares: BigInt, availablePayment: Money)(implicit conv: CurrencyConversion[availablePayment.currency.type, askingPrice.currency.type]) =
    availablePayment.convertToForeignCurrency(conv).units >= askingPrice.units
}
