package sfti.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import sfti.exercises.Chapter4._
import sfti.exercises.Util._

@RunWith(classOf[JUnitRunner])
class Chapter4Test extends FunSuite {

  test("test exercise #1 - priceMapToDiscountMap") {
    val discount: Double = 0.1
    val priceMap = Map[String, Double](
      "MBP" -> 4000.0,
      "iPhone" -> 400.0,
      "TV" -> 1500.0)
    val discountMap = priceMapToDiscountMap(priceMap, discount)
    assert(discountMap.size == 3)
    assert(discountMap.forall(
      i =>
        i._2 == getDiscountedValue(priceMap(i._1), discount)))
  }

  test("test exercise #2 - mutableMapWordFreqs") {
    val mutableWordFreqs = mutableMapWordFreqs("hello.txt")
    printWordFreqs(mutableWordFreqs)
  }

  test("test exercise #3 - immutableMapWordFreqs") {
    val immutableWordFreqs = immutableMapWordFreqs("hello.txt")
    printWordFreqs(immutableWordFreqs)
    println()
    val immutableWordFreqs2 = immutableMapWordFreqs2("hello.txt")
    printWordFreqs(immutableWordFreqs2)
  }

  test("test exercise #4 - sortedMapWordFreqs") {
    val sortedWordFreqs = sortedMapWordFreqs("hello.txt")
    printWordFreqs(sortedWordFreqs)
  }

  test("test exercise #5 - treeMapWordFreqs") {
    val treeWordFreqs = treeMapWordFreqs("hello.txt")
    //for ((k,v) <- treeWordFreqs) println(k + ": " + v)
  }

  test("test exercise #6 - weekdayMap") {
    println("weekdayMap: "+weekdayMap)
    assert(weekdayMap.size == 7)
    assert(weekdayMap.head._1 == "Monday")
    assert(weekdayMap.head._2 == 2)
    assert(weekdayMap.last._1 == "Sunday")
    assert(weekdayMap.last._2 == 1)
  }

  test("test exercise #7 - printJavaProperties") {
    println("printJavaProperties():")
    printJavaProperties()
  }

  test("test exercise #8 - minmax") {
    val a1 = Array(1)
    println("a1: " + arrayToString(a1))
    println("minmax(a1): " + minmax(a1).toString())
    assert(minmax(a1) === (1,1))

    val a2 = Array(1,2,3,4,5,6,7,8,9)
    println("a1to9: " + arrayToString(a2))
    println("minmax(a1to9): " + minmax(a2).toString())
    assert(minmax(a2) === (1,9))

    val a3 = Array(-9, 1, 2, -8)
    println("arnd: " + arrayToString(a3))
    println("minmax(arnd): " + minmax(a3).toString())
    assert(minmax(a3) === (-9, 2))
  }

  test("test exercise #9 - lteqgt") {
    val a1 = Array(1)
    println("a1: " + arrayToString(a1))
    println("lteqgt(a1, 4): " + lteqgt(a1, 4).toString())
    assert(lteqgt(a1, 4) === (1,0,0))

    val a2 = Array(1,2,3,4,5,6,7,8,9)
    println("a2: " + arrayToString(a2))
    println("lteqgt(a2, 4): " + lteqgt(a2, 4).toString())
    assert(lteqgt(a2, 4) === (3,1,5))

    val a3 = Array(-9, 1, 2, -8)
    println("a3: " + arrayToString(a3))
    println("lteqgt(a3, 4): " + lteqgt(a3, 4).toString())
    assert(lteqgt(a3, 4) === (4, 0, 0))
  }

  test("test exercise #10 - zipStrings") {
    val hello = "Hello,"
    val world = "world!"
    val zipped = zipStrings(hello, world)
    println("zipped: " + zipped)
    assert(zipped == "Hweolrllod,!")
  }
}
