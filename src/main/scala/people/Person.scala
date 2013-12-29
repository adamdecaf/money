package com.decaf.money

case class Person(
  name: String,
  age: Int,
  money: Seq[Money],
  purchases: Seq[Payment[_, _]]
) {
  def moneySum[Final <: Currency](implicit conv: CurrencyConversion[_, Final]): BigDecimal =
    money.map(CurrencyConversion(_).units).sum
}
