package com.decaf.money

trait MarketActorModule {
  import akka.pattern.ask
  import scala.concurrent.duration._
  private[this] val timeout = Timeout(10.seconds)

  def getMarket()(implicit t: Timeout = timeout): Future[Option[Market]] =
    (MarketActorSpawn.actor ? GetMarketDetails).mapTo[Option[Market]]
}
