package com.decaf.money

final case class Currency(
  name: String
)

object Currency {
  final val USD = Currency("United States Dollars")
  final val GBP = Currency("Brittish Pounts")
}
