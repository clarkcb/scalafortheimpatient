package scalafortheimpatient.exercises

import scala.beans.BeanProperty

/*
  Exercises to do (8): 1, 2, 3, 4, 5, 6, 7, 8
 */
object Chapter5 {

  /* 1) Improve the Counter class in Section 5.1, “Simple Classes and
        Parameterless Methods,” on page 49 so that it doesn’t turn negative at
        Int.MaxValue. */
  class Counter {
    private var value:Int = 0 // You must initialize the field
    def increment() { // Methods are public by default
      if (value < Int.MaxValue) value += 1
    }
    def current = value
  }

  /* 2) Write a class BankAccount with methods deposit and withdraw, and a
        read-only property balance. */
  class BankAccount {
    private var _balance = 0
    def balance = _balance
    def deposit(value:Int) {
      _balance += value
    }
    def withdraw(value:Int): Int = {
      if (_balance >= value) {
        _balance -= value
        value
      } else {
       0
      }
    }
  }

  /* 3) Write a class Time with read-only properties hours and minutes and a
        method before(other:Time): Boolean that checks whether this time comes
        before the other. A Time object should be constructed as new Time(hrs,min)
        where hrs is in military time format (between 0 and 23) */
  class Time(val hrs:Int, val min:Int) {
    require(hrs > -1 && hrs < 24)
    require(min > -1 && min < 61)
    def before(other:Time): Boolean = {
      hrs < other.hrs || hrs == other.hrs && min < other.min
    }
    override def toString: String = "Time(%d:%d)".format(hrs,min)
  }

  /* 4) Reimplement the Time class from the preceding exercise so that the
        internal representation is the number of minutes since midnight (between
        0 and 24 × 60 – 1). Do not change the public interface. That is, client
        code should be unaffected by your change. */
  class Time2(val hrs:Int, val min:Int) {
    require(hrs > -1 && hrs < 24)
    require(min > -1 && min < 61)
    private val minsFromMidnight = hrs * 60 + min
    def before(other:Time2): Boolean = {
      minsFromMidnight < other.minsFromMidnight
    }
    override def toString: String = "Time(%d:%d)".format(hrs,min)
  }

  /* 5) Make a class Student with read-write JavaBeans properties name (of type
        String) and id (of type Long). What methods are generated? (Use javap to
        check.) Can you call the JavaBeans getters and setters in Scala? Should
        you? */
  class Student(@BeanProperty val id:Long, @BeanProperty val name:String) {
    override def toString: String = "Student(%d: %s)".format(id,name)
  }

  /* 6) In the Person class of Section 5.1, “Simple Classes and Parameterless
        Methods Why No Multiple Inheritance?,” on page 49, provide a primary
        constructor that turns negative ages to 0. */
  class Person(_age:Int) {
    val age = if (_age > 0) _age else 0
    override def toString: String = "Person(age=%d)".format(age)
  }

  /* 7) Write a class Person with a primary constructor that accepts a string
        containing a first name, a space, and a last name, such as new
        Person("Fred Smith"). Supply read-only properties firstName and
        lastName. Should the primary constructor parameter be a var, a val, or
        a plain parameter? Why? */
  // use plain parameter
  class Person2(fullName:String) {
    val firstName :: lastName :: Nil = fullName.split("\\s+").toList
    override def toString: String = """Person2("%s %s")""".format(firstName, lastName)
  }

  /* 8) Make a class Car with read-only properties for manufacturer, model name,
        and model year, and a read-write property for the license plate. Supply
        four constructors. All require the manufacturer and model name.
        Optionally, model year and license plate can also be specified in the
        constructor. If not, the model year is set to -1 and the license plate
        to the empty string. Which constructor are you choosing as the primary
        constructor? Why? */
  class Car(val manufacturer:String, val modelName:String, val modelYear:Int,
            var licensePlate:String) {
    def this(manufacturer:String, modelName:String) {
      this(manufacturer, modelName, -1, "")
    }
    def this(manufacturer:String, modelName:String, modelYear:Int) {
      this(manufacturer, modelName, modelYear, "")
    }
    def this(manufacturer:String, modelName:String, licensePlate:String) {
      this(manufacturer, modelName, -1, licensePlate)
    }
    override def toString: String =
      "Car(%s %s%s%s)".format(manufacturer, modelName,
        if (modelYear > -1) " " + modelYear.toString else "",
        if (licensePlate.nonEmpty) " " + licensePlate else "")
  }
}