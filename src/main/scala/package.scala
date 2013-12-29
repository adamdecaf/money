package com.decaf

package object money {
  type DateTime = org.joda.time.DateTime
  def now = org.joda.time.DateTime.now

  type Future[A] = scala.concurrent.Future[A]

  protected[money] implicit lazy val MoneyActorSystem = akka.actor.ActorSystem("money")

  abstract class Actor extends akka.actor.Actor
  trait ActorLogging extends akka.actor.ActorLogging { this: Actor => }
  def LoggingReceive = akka.event.LoggingReceive
  def Props = akka.actor.Props
  type Timeout = akka.util.Timeout
  def Timeout = akka.util.Timeout
}
