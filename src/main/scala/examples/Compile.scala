package com.decaf.money.examples
import com.decaf.money._

object Compile extends CurrencyConversions {
  import Currency._

  val Walmart = Company("Wal-Mart", now.minusYears(40))
  val BrittishAirways = Company("Brittish Airways", now.minusYears(30))

  val lotsOfDollars = Money(USD, BigDecimal(1000))
  val logsOfPounds = Money(GBP, BigDecimal(1000))
  val aFewDollars = Money(USD, BigDecimal(20))
  val aFewPounds = Money(GBP, BigDecimal(20))

  val walmartAskingPrice = Money(USD, BigDecimal(110))
  val walmartsStock = Stock(Walmart.name, Walmart, BigInt(5000), walmartAskingPrice)

  val brittishAirwaysAskingPrice = Money(GBP, BigDecimal(60))
  val brittishAirwaysStock = Stock(BrittishAirways.name, BrittishAirways, BigInt(4000), brittishAirwaysAskingPrice)

  val richMe = Person("Me", 100, Seq(Money(USD, BigDecimal("100.00")), Money(GBP, BigDecimal("200.00"))), Seq.empty)

  def run() {
    implicitly[CurrencyConversion[USD.type, GBP.type]]

    implicitly[lotsOfDollars.currency.type =:= walmartsStock.askingPrice.currency.type]
    implicitly[CurrencyConversion[lotsOfDollars.currency.type, walmartsStock.askingPrice.currency.type]]

    println(s"USD: ${lotsOfDollars.units}, 3 shares of Walmart: ${walmartsStock.canAffordPurchase(3, lotsOfDollars)}")
    println(s"I have ${richMe.moneySum[USD.type]} dollars or ${richMe.moneySum[GBP.type]} brittish pounds")
  }
}
