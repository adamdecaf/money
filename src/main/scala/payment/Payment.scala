package com.decaf.money

object PaymentType extends Enumeration {
  val InPerson = Value(1)
  val Check = Value(2)
  val Electronic = Value(3)
  val Credit = Value(4)
}

trait Payment[Seller <: AnyRef, Buyer <: AnyRef]{
  def seller: Seller
  def buyer: Buyer
  def amount: Money
  def date: DateTime
}

case class CompanyToCompanyPayment(
  seller: Company,
  buyer: Company,
  amount: Money,
  date: DateTime
) extends Payment[Company, Company]

case class CompenyToPersonPayment(
  seller: Company,
  buyer: Person,
  amount: Money,
  date: DateTime
) extends Payment[Company, Person]

case class PersonToCompanyPayment(
  seller: Person,
  buyer: Company,
  amount: Money,
  date: DateTime
) extends Payment[Person, Company]

case class PersonToPersonPayment(
  seller: Person,
  buyer: Person,
  amount: Money,
  date: DateTime
) extends Payment[Person, Person]
