package com.decaf.money

final case class Market(
  name: String,
  stocks: Seq[Stock],
  openingTime: DateTime,
  closingTime: DateTime
)
