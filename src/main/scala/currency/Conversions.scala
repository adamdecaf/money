package com.decaf.money
import java.util.concurrent.ConcurrentHashMap

private[money] object ConversionsCache {
  private[this] val cache = new ConcurrentHashMap[String, BigDecimal]()

  def get(curr: Currency): Option[BigDecimal] =
    Option(cache.get(curr.name))

  def put(curr: Currency, conv: CurrencyConversion[_, _]): Unit =
    cache.put(curr.name, conv.ratio)

  def put(curr: Currency, ratio: BigDecimal): Unit =
    cache.put(curr.name, ratio)
}

trait CurrencyConversions {
  import Currency._

  protected implicit object USD2GBP extends CurrencyConversion[UnitedStatesDollars.type, BrittishPounds.type] {
    val ratio = BigDecimal("0.61")
  }

  protected implicit object GBP2USD extends CurrencyConversion[BrittishPounds.type, UnitedStatesDollars.type] {
    val ratio = BigDecimal("1.65")
  }
}
