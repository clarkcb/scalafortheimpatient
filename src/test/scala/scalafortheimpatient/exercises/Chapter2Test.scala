package scalafortheimpatient.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scalafortheimpatient.exercises.Chapter2._

@RunWith(classOf[JUnitRunner])
class Chapter2Test extends FunSuite {

  test("test signum") {
    println("signum(1): " + signum(1))
    assert(signum(1) == 1)
    println("signum(0): " + signum(0))
    assert(signum(0) == 0)
    println("signum(-1): " + signum(-1))
    assert(signum(-1) == -1)
    println("signum(-123): " + signum(-123))
    assert(signum(-123) == -1)
    println("signum(123): " + signum(123))
    assert(signum(123) == 1)
  }

  test("test unicodeProductLoop") {
    println("""unicodeProductLoop("Hello"): """ + unicodeProductLoop("Hello"))
    assert(unicodeProductLoop("Hello") == 9415087488L)
  }

  test("test unicodeProductNoLoop") {
    println("""unicodeProductNoLoop("Hello"): """ + unicodeProductNoLoop("Hello"))
    assert(unicodeProductNoLoop("Hello") == 9415087488L)
  }

  test("test recUnicodeProduct") {
    println("""recUnicodeProduct("Hello"): """ + recUnicodeProduct("Hello"))
    assert(recUnicodeProduct("Hello") == 9415087488L)
  }

  test("test recUnicodeProduct2") {
    println("""recUnicodeProduct2("Hello"): """ + recUnicodeProduct2("Hello"))
    assert(recUnicodeProduct2("Hello") == 9415087488L)
  }

  test("test recUnicodeProduct3") {
    println("""recUnicodeProduct3("Hello"): """ + recUnicodeProduct3("Hello"))
    assert(recUnicodeProduct3("Hello") == 9415087488L)
  }

  test("test xPowN") {
    println("""xPowN(2, 2): """ + xPowN(2, 2))
    assert(xPowN(2, 2) == 4.0)
    println("""xPowN(10, 2): """ + xPowN(10, 2))
    assert(xPowN(10, 2) == 100.0)
  }

}
