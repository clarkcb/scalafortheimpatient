package sfti.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import sfti.exercises.Chapter3._
import sfti.exercises.Util._

@RunWith(classOf[JUnitRunner])
class Chapter3Test extends FunSuite {

  test("test exercise #1 - randomIntArray") {
    val arr = randomIntArray(10)
    println("arr: " + arr.mkString("Array(", ",", ")"))
    assert(arr.length == 10)
    assert(arr.forall(i => i >=0 && i < 10))
  }

  test("test exercise #2, 3 - swapAdjacent") {
    val a1 = Array(1)
    println("a1: " + arrayToString(a1))
    println("swapAdjacent(a1): " + arrayToString(swapAdjacent(a1)))
    assert(swapAdjacent(a1) === a1)

    val a12 = Array(1, 2)
    println("a12: " + arrayToString(a12))
    println("swapAdjacent(a12): " + arrayToString(swapAdjacent(a12)))
    assert(swapAdjacent(a12) === a12.reverse)

    val a123 = Array(1, 2, 3)
    println("a123: " + arrayToString(a123))
    println("swapAdjacent(a123): " + arrayToString(swapAdjacent(a123)))
    assert(swapAdjacent(a123) === Array(2, 1, 3))

    val a1234 = Array(1, 2, 3, 4)
    println("a1234: " + arrayToString(a1234))
    println("swapAdjacent(a1234): " + arrayToString(swapAdjacent(a1234)))
    assert(swapAdjacent(a1234) === Array(2, 1, 4, 3))

    val a12345 = Array(1, 2, 3, 4, 5)
    println("a12345: " + arrayToString(a12345))
    println("swapAdjacent(a12345): " + arrayToString(swapAdjacent(a12345)))
    assert(swapAdjacent(a12345) === Array(2, 1, 4, 3, 5))
  }

  test("test exercise #4 - positiveThenNegative") {
    val a1 = Array(1)
    println("a1: " + arrayToString(a1))
    println("positiveThenNegative(a1): " +
      arrayToString(positiveThenNegative(a1)))
    assert(positiveThenNegative(a1) === a1)

    val a12 = Array(-1, 2)
    println("a12: " + arrayToString(a12))
    println("positiveThenNegative(a12): " +
      arrayToString(positiveThenNegative(a12)))
    assert(positiveThenNegative(a12) === Array(2, -1))

    val a123 = Array(1, -2, 3)
    println("a123: " + arrayToString(a123))
    println("positiveThenNegative(a123): " +
      arrayToString(positiveThenNegative(a123)))
    assert(positiveThenNegative(a123) === Array(1, 3, -2))

    val a1234 = Array(-1, 2, -3, 4)
    println("a1234: " + arrayToString(a1234))
    println("positiveThenNegative(a1234): " +
      arrayToString(positiveThenNegative(a1234)))
    assert(positiveThenNegative(a1234) === Array(2, 4, -1, -3))

    val a12345 = Array(1, -2, 3, -4, 5)
    println("a12345: " + arrayToString(a12345))
    println("positiveThenNegative(a12345): " +
      arrayToString(positiveThenNegative(a12345)))
    assert(positiveThenNegative(a12345) === Array(1, 3, 5, -2, -4))
  }

  test("test exercise #4a - positiveThenNegativeByPartition") {
    val a1 = Array(1)
    println("a1: " + arrayToString(a1))
    println("positiveThenNegativeByPartition(a1): " +
      positiveThenNegativeByPartition(a1).mkString("Array(",",",")"))
    assert(positiveThenNegativeByPartition(a1) === a1)

    val a12 = Array(-1, 2)
    println("a12: " + arrayToString(a12))
    println("positiveThenNegativeByPartition(a12): " +
      positiveThenNegativeByPartition(a12).mkString("Array(",",",")"))
    assert(positiveThenNegativeByPartition(a12) === Array(2, -1))

    val a123 = Array(1, -2, 3)
    println("a123: " + arrayToString(a123))
    println("positiveThenNegativeByPartition(a123): " +
      positiveThenNegativeByPartition(a123).mkString("Array(",",",")"))
    assert(positiveThenNegativeByPartition(a123) === Array(1, 3, -2))

    val a1234 = Array(-1, 2, -3, 4)
    println("a1234: " + arrayToString(a1234))
    println("positiveThenNegativeByPartition(a1234): " +
      positiveThenNegativeByPartition(a1234).mkString("Array(",",",")"))
    assert(positiveThenNegativeByPartition(a1234) === Array(2, 4, -1, -3))

    val a12345 = Array(1, -2, 3, -4, 5)
    println("a12345: " + arrayToString(a12345))
    println("positiveThenNegativeByPartition(a12345): " +
      positiveThenNegativeByPartition(a12345).mkString("Array(",",",")"))
    assert(positiveThenNegativeByPartition(a12345) === Array(1, 3, 5, -2, -4))
  }

  test("test exercise #5 - computeAverageArrayDouble") {
    val a1 = Array[Double](1)
    println("a1: " + arrayToString(a1))
    println("computeAverageArrayDouble(a1): " + computeAverageArrayDouble(a1))
    assert(computeAverageArrayDouble(a1) == 1.0)
    val a2 = Array[Double](1,2)
    println("a2: " + arrayToString(a2))
    println("computeAverageArrayDouble(a2): " + computeAverageArrayDouble(a2))
    assert(computeAverageArrayDouble(a2) == 1.5)
    val a3 = Array[Double](1,2,3,4,5)
    println("a3: " + arrayToString(a3))
    println("computeAverageArrayDouble(a3): " + computeAverageArrayDouble(a3))
    assert(computeAverageArrayDouble(a3) == 3.0)
  }

  test("test exercise #6 - reverse") {
    val a1 = Array[Int](1,2,3,4,5)
    println("a1: " + arrayToString(a1))
    println("reverseArrayInt(a1): " + arrayToString(reverseArrayInt(a1)))
    assert(reverseArrayInt(a1) === Array[Int](5,4,3,2,1))
  }

  test("test exercise #7 - arrayNoDups") {
    val a1 = Array(1)
    println("a1: " + arrayToString(a1))
    println("arrayNoDups(a1): " + arrayToString(arrayNoDups(a1)))
    assert(arrayNoDups(a1) === a1)

    val a11 = Array(1, 1)
    println("a11: " + arrayToString(a11))
    println("arrayNoDups(a11): " + arrayToString(arrayNoDups(a11)))
    assert(arrayNoDups(a11) === Array(1))

    val a112 = Array(1, 1, 2)
    println("a112: " + arrayToString(a112))
    println("arrayNoDups(a112): " + arrayToString(arrayNoDups(a112)))
    assert(arrayNoDups(a112) === Array(1, 2))

    val a121 = Array(1, 2, 1)
    println("a121: " + arrayToString(a121))
    println("arrayNoDups(a121): " + arrayToString(arrayNoDups(a121)))
    assert(arrayNoDups(a121) === Array(1, 2))

    val a123123321 = Array(1,2,3,1,2,3,3,2,1)
    println("a123123321: " + arrayToString(a123123321))
    println("arrayNoDups(a123123321): " + arrayToString(arrayNoDups(a123123321)))
    assert(arrayNoDups(a123123321) === Array(1, 2, 3))
  }

  test("test exercise #9 - americanTimeZones") {
    println("americanTimeZones (%d): %s".format(americanTimeZones.length,
      americanTimeZones.mkString(", ")))
    assert(americanTimeZones.length == 164)
    assert(americanTimeZones.contains("Los_Angeles"))
  }

}
