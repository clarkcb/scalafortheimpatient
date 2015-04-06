package scalafortheimpatient.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scalafortheimpatient.exercises.Chapter5._

@RunWith(classOf[JUnitRunner])
class Chapter5Test extends FunSuite {

  test("test exercise #1 - Counter class") {
    val counter = new Counter()
    println("Starting count: "+counter.current)
    assert(counter.current == 0)
    (1 to 2147483646).foreach(i => counter.increment())
    println("New count: "+counter.current)
    counter.increment()
    assert(counter.current == 2147483647) // Int.MaxValue
    println("New count: "+counter.current)
    counter.increment()
    println("New count: "+counter.current)
    assert(counter.current == 2147483647)
  }

  test("test exercise #2 - BankAccount class") {
    val account = new BankAccount()
    println("Starting balance: "+account.balance)
    assert(account.balance == 0)
    account.deposit(1000)
    println("Balance after $1000 deposit: "+account.balance)
    assert(account.balance == 1000)
    account.withdraw(500)
    println("Balance after $500 withdrawal: "+account.balance)
    assert(account.balance == 500)
    account.withdraw(501)
    println("Balance after (attempted) $501 withdrawal: "+account.balance)
    assert(account.balance == 500)
  }

  test("test exercise #3 - Time class") {
    val twelveThirty = new Time(12, 30)
    println("twelveThirty: "+twelveThirty)
    assert(twelveThirty.hrs == 12)
    assert(twelveThirty.min == 30)
    val elevenThirty = new Chapter5.Time(11, 30)
    assert(elevenThirty before twelveThirty)
    val twelveTwenty = new Chapter5.Time(12, 20)
    assert(twelveTwenty before twelveThirty)
    val twelveForty = new Chapter5.Time(12, 40)
    assert(twelveThirty before twelveForty)
  }

  test("test exercise #4 - Time2 class") {
    val twelveThirty = new Time2(12, 30)
    println("twelveThirty: "+twelveThirty)
    assert(twelveThirty.hrs == 12)
    assert(twelveThirty.min == 30)
    val elevenThirty = new Chapter5.Time2(11, 30)
    assert(elevenThirty before twelveThirty)
    val twelveTwenty = new Chapter5.Time2(12, 20)
    assert(twelveTwenty before twelveThirty)
    val twelveForty = new Chapter5.Time2(12, 40)
    assert(twelveThirty before twelveForty)
  }

  test("test exercise #6 - Person class") {
    val person = new Person(45)
    println("person: "+person)
    assert(person.age == 45)
    val unborn = new Person(-1)
    println("unborn: "+unborn)
    assert(unborn.age == 0)
  }

  test("test exercise #7 - Person2 class") {
    val person = new Person2("Cary Clark")
    println("person: "+person)
    assert(person.firstName == "Cary")
    assert(person.lastName == "Clark")
  }

  test("test exercise #8 - Car class") {
    val car = new Car("Honda", "Civic")
    println("car: "+car)
    assert(car.manufacturer == "Honda")
    assert(car.modelName == "Civic")
    assert(car.modelYear == -1)
    assert(car.licensePlate == "")
    val car2 = new Car("Honda", "Civic", 1996)
    println("car2: "+car2)
    val car3 = new Car("Honda", "Civic", "XYZ123")
    println("car3: "+car3)
    val car4 = new Car("Honda", "Civic", 1996, "XYZ123")
    println("car4: "+car4)
  }

}
