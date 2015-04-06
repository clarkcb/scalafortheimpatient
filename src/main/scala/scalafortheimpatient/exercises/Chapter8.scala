package sfti.exercises

import scala.collection.mutable

/*
  Exercises to do (9): 1, 2, 4, 5, 6, 7, 8, 9, 10
 */
object Chapter8 {

  /* 1) Extend the following BankAccount class to a CheckingAccount class that
        charges $ 1 for every deposit and withdrawal.

        class BankAccount(initialBalance: Double) {
          private var balance = initialBalance
          def deposit(amount: Double) = { balance += amount; balance }
          def withdraw(amount: Double) = { balance -= amount; balance }
        } */

  class BankAccount(initialBalance: Double) {
    private var _balance = initialBalance
    def balance = _balance
    def deposit(amount: Double): Double = { _balance += amount; _balance }
    def withdraw(amount: Double): Double = { _balance -= amount; _balance }
    override def toString: String = "%s(%s)".format(getClass.getName,
      _balance.toString)
  }

  class CheckingAccount(initBal: Double) extends BankAccount(initBal) {
    private val fee = 1
    override def deposit(amount: Double): Double = {
      super.deposit(amount-fee)
    }
    override def withdraw(amount: Double): Double = {
      super.withdraw(amount+fee)
    }
  }

  /* 2) Extend the BankAccount class of the preceding exercise into a class
        SavingsAccount that earns interest every month (when a method
        earnMonthlyInterest is called) and has three free deposits or
        withdrawals every month. Reset the transaction count in the
        earnMonthlyInterest method. */
  class SavingsAccount(initBal: Double) extends BankAccount(initBal) {
    private val fee = 1
    private val maxFreeTransactions = 3
    private var currentTransactions = 0
    private val interestRate = 0.05
    override def deposit(amount: Double): Double = {
      super.deposit(amount)
      currentTransactions += 1
      if (currentTransactions > maxFreeTransactions) super.withdraw(fee)
      else balance
    }
    override def withdraw(amount: Double): Double = {
      super.withdraw(amount)
      currentTransactions += 1
      if (currentTransactions > maxFreeTransactions) super.withdraw(fee)
      else balance
    }
    def interestEarned = balance * interestRate
    def earnMonthlyInterest() {
      super.deposit(interestEarned)
      currentTransactions = 0
    }
  }

  /* 3) Consult your favorite Java or C + + textbook that is sure to have an
        example of a toy inheritance hierarchy, perhaps involving employees,
        pets, graphical shapes, or the like. Implement the example in Scala. */
// skipping this one

  /* 4) Define an abstract class Item with methods price and description. A
        SimpleItem is an item whose price and description are specified in the
        constructor. Take advantage of the fact that a val can override a def.
        A Bundle is an item that contains other items. Its price is the sum of
        the prices in the bundle. Also provide a mechanism for adding items to
        the bundle and a suitable description method. */
  abstract class Item {
    def price: Double
    def description: String
  }

  class SimpleItem(val price:Double, val description:String) extends Item {
    override def toString = "%s for $%.02f".format(description, price)
  }

  class Bundle extends Item {
    private var items = mutable.ArrayBuffer.empty[Item]
    def price = items.map(_.price).sum
    def addItem(item:Item) {
      items += item
    }
    def description = {
      val itemsName = if (items.length == 1) "item" else "items"
      "Bundle of %d %s for $%.02f".format(items.length, itemsName, price)
    }
    override def toString = description
  }

  /* 5) Design a class Point whose x and y coordinate values can be provided in
        a constructor. Provide a subclass LabeledPoint whose constructor takes a
        label value and x and y coordinates, such as new LabeledPoint("Black
        Thursday", 1929, 230.07) */
  class Point(val x:Int, val y:Int) {
    override def toString = "Point(%d, %d)".format(x, y)
  }
  class LabeledPoint(val label:String, x:Int, y:Int) extends Point(x, y) {
    override def toString = """LabeledPoint("%s", %d, %d)""".format(label, x, y)
  }

  /* 6) Define an abstract class Shape with an abstract method centerPoint and
        subclasses Rectangle and Circle. Provide appropriate constructors for
        the subclasses and override the centerPoint method in each subclass. */
  abstract class Shape {
    def centerPoint: Point
  }

  class Rectangle(val length:Int, val width:Int) extends Shape {
    def centerPoint = new Point(length / 2, width / 2)
    override def toString = "Rectangle(%d, %d)".format(length, width)
  }

  class Circle(val radius:Int) extends Shape {
    def centerPoint = new Point(radius, radius)
    override def toString = "Circle(r=%d)".format(radius)
  }

  /* 7) Provide a class Square that extends java.awt.Rectangle and has three
        constructors: one that constructs a square with a given corner point and
        width, one that constructs a square with corner (0, 0) and a given
        width, and one that constructs a square with corner (0, 0) and width
        0. */
  class Square(val point:Point, width:Int) extends
    java.awt.Rectangle(point.x, point.y, width, width) {
    def this(width:Int) = this(new Point(0,0), width)
    def this() = this(new Point(0,0), 0)
    override def toString = "Square(%s, %d)".format(point.toString, width)
  }

  /* 8) Compile the Person and SecretAgent classes in Section 8.6, “Overriding
        Fields,” on page 89 and analyze the class files with javap. How many
        name fields are there? How many name getter methods are there? What do
        they get? (Hint: Use the -c and -private options.) */


  /* 9) In the Creature class of Section 8.10, “Construction Order and Early
        Definitions,” on page 92, replace val range with a def. What happens
        when you also use a def in the Ant subclass? What happens when you use a
        val in the subclass? Why? */


  /* 10) The file scala/collection/immutable/Stack.scala contains the
         definition class Stack[A] protected (protected val elems: List[A])
         Explain the meanings of the protected keywords. (Hint: Review the
         discussion of private constructors in Chapter 5.) */


  def main(args: Array[String]) {
  }
}