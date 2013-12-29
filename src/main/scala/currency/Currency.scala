package com.decaf.money

final case class Currency(
  name: String
)

object Currency {
  final val UnitedStatesDollars = Currency("United States Dollars")
  final val BrittishPounds = Currency("Brittish Pounts")
}
