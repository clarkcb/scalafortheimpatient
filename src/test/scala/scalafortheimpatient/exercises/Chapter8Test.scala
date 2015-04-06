package scalafortheimpatient.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scalafortheimpatient.exercises.Chapter8._

@RunWith(classOf[JUnitRunner])
class Chapter8Test extends FunSuite {

  // #1
  test("test CheckingAccount") {
    val checkingAccount = new CheckingAccount(1000)
    println("checkingAccount: "+checkingAccount)
    println("checkingAccount.balance: "+checkingAccount.balance)
    assert(checkingAccount.balance == 1000)
    println("Depositing $1000.00")
    checkingAccount.deposit(1000)
    println("checkingAccount: "+checkingAccount)
    println("checkingAccount.balance: "+checkingAccount.balance)
    assert(checkingAccount.balance == 1999)
    println("Withdrawing $1000.00")
    checkingAccount.withdraw(1000)
    println("checkingAccount: "+checkingAccount)
    println("checkingAccount.balance: "+checkingAccount.balance)
    assert(checkingAccount.balance == 998)
  }

  // #2
  test("test SavingsAccount") {
    val savingsAccount = new SavingsAccount(1000)
    println("savingsAccount: "+savingsAccount)
    assert(savingsAccount.balance == 1000)
    println("Depositing $1000.00")
    savingsAccount.deposit(1000)
    println("savingsAccount: "+savingsAccount)
    assert(savingsAccount.balance == 2000)
    println("Depositing $1000.00")
    savingsAccount.deposit(1000)
    println("savingsAccount: "+savingsAccount)
    assert(savingsAccount.balance == 3000)
    println("Depositing $1000.00")
    savingsAccount.deposit(1000)
    println("savingsAccount: "+savingsAccount)
    assert(savingsAccount.balance == 4000)
    println("Depositing $1000.00")
    savingsAccount.deposit(1000)
    println("savingsAccount: "+savingsAccount)
    assert(savingsAccount.balance == 4999)
    println("Withdrawing $1000.00")
    savingsAccount.withdraw(1000)
    println("savingsAccount: "+savingsAccount)
    assert(savingsAccount.balance == 3998)
    println("Earning monthly interest of %s".format(savingsAccount.interestEarned.toString))
    savingsAccount.earnMonthlyInterest()
    println("savingsAccount: "+savingsAccount)
  }

  // #4
  test("test Item, SimpleItem and Bundle") {
    val item1 = new SimpleItem(2200, "MBP")
    println("item1: " + item1)
    val item2 = new SimpleItem(400, "iPhone")
    println("item2: " + item2)
    val item3 = new SimpleItem(250, "iPad")
    println("item3: " + item3)
    val bundle = new Bundle()
    bundle.addItem(item1)
    bundle.addItem(item2)
    bundle.addItem(item3)
    println("bundle: " + bundle)
  }

  // #5
  test("test Point and LabeledPoint") {
    val p1 = new Point(0,0)
    println("p1: " + p1)
    val p2 = new Point(50,50)
    println("p2: " + p2)
    val origin = new LabeledPoint("origin", p1.x, p1.y)
    println("origin: " + origin)
    val maxPoint = new LabeledPoint("max point", p2.x, p2.y)
    println("maxPoint: " + maxPoint)
  }

  // #6
  test("test Shape, Rectangle and Circle") {
    val r1 = new Rectangle(10, 5)
    println("r1: " + r1)
    val c1 = new Circle(5)
    println("c1: " + c1)
  }

  // #7
  test("test Square") {
    val s1 = new Square(new Point(0, 0), 5)
    println("s1: " + s1)
    val s2 = new Square(10)
    println("s2: " + s2)
    val s3 = new Square()
    println("s3: " + s3)
  }

}
