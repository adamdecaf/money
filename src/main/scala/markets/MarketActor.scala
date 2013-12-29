package com.decaf.money

trait MarketActor extends BaseActor {
  private[this] val mockMarket = Market(
    "Mock Market",
    Seq(
      Stock(
        "Sample Company",
        Company("Sample Company", now.minusYears(10)),
        BigInt("10000"),
        Money(
          Currency.UnitedStatesDollars,
          BigDecimal("120.32")
        )
      )
    ),
    now.withTimeAtStartOfDay.withHourOfDay(9),
    now.withTimeAtStartOfDay.withHourOfDay(17)
  )

  def receive: Receive = LoggingReceive {
    case GetMarketDetails => sender ! Some(mockMarket)
  }
}

class MarketActorSpawn extends MarketActor
object MarketActorSpawn {
  lazy val actor = MoneyActorSystem.actorOf(Props(classOf[MarketActorSpawn]), "market-actor")
  //lazy val actor = MoneyActorSystem.actorOf(Props[MarketActorSpawn], "market-actor")
}
