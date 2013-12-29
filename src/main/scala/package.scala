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

  // From shapeless: https://github.com/milessabin/shapeless/blob/master/core/src/main/scala/shapeless/package.scala#L36
  // Type inequalities
  def unexpected : Nothing = sys.error("Unexpected invocation")
  trait =:!=[A, B]

  implicit def neq[A, B] : A =:!= B = new =:!=[A, B] {}
  implicit def neqAmbig1[A] : A =:!= A = unexpected
  implicit def neqAmbig2[A] : A =:!= A = unexpected

  trait <:!<[A, B]

  implicit def nsub[A, B] : A <:!< B = new <:!<[A, B] {}
  implicit def nsubAmbig1[A, B >: A] : A <:!< B = unexpected
  implicit def nsubAmbig2[A, B >: A] : A <:!< B = unexpected
}
