package sfti.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import sfti.exercises.Chapter12._
import sfti.exercises.Util._

@RunWith(classOf[JUnitRunner])
class Chapter12Test extends FunSuite {

  // #1
  test("test exercise 1: values") {
    val valSeq = values(x => x * x, -5, 5)
    val expected = Seq[(Int,Int)]((-5,25),(-4,16),(-3,9),(-2,4),(-1,1),(0,0),
      (1,1),(2,4), (3,9), (4,16), (5,25))
    assert(valSeq == expected)
  }

  // #2
  test("test exercise 2: largestFromReduceLeft") {
    val arr = Array(1,9,2,8,3,7,4,6,5)
    val largestFrom = largestFromReduceLeft(arr)
    val expected = 9
    assert(largestFrom == expected)
  }

  // #3
  test("test exercise 3: factorialFromToAndReduceLeft") {
    val r0 = factorialFromToAndReduceLeft(0)
    assert(r0 == 1)
    val r1 = factorialFromToAndReduceLeft(1)
    assert(r1 == 1)
    val r2 = factorialFromToAndReduceLeft(2)
    assert(r2 == 2)
    val r3 = factorialFromToAndReduceLeft(3)
    assert(r3 == 6)
    val r4 = factorialFromToAndReduceLeft(4)
    assert(r4 == 24)
    val r5 = factorialFromToAndReduceLeft(5)
    assert(r5 == 120)
    val rn5 = factorialFromToAndReduceLeft(-5)
    assert(rn5 == -120)
  }

  // #4
  test("test exercise 4: factorialFromFoldLeft") {
    val r0 = factorialFromFoldLeft(0)
    assert(r0 == 1)
    val r1 = factorialFromFoldLeft(1)
    assert(r1 == 1)
    val r2 = factorialFromFoldLeft(2)
    assert(r2 == 2)
    val r3 = factorialFromFoldLeft(3)
    assert(r3 == 6)
    val r4 = factorialFromFoldLeft(4)
    assert(r4 == 24)
    val r5 = factorialFromFoldLeft(5)
    assert(r5 == 120)
    val rn5 = factorialFromFoldLeft(-5)
    assert(rn5 == -120)
  }

  // #5
  test("test exercise 5: largest") {
    val r1 = largest(x => 10 * x - x * x, 1 to 10)
    assert(r1 == 25)
    val r2 = largest(x => 10 * x - x * 2, 1 to 10)
    assert(r2 == 80)
    val r3 = largest2(x => 10 * x - x * x, 1 to 10)
    assert(r3 == 25)
    val r4 = largest2(x => 10 * x - x * 2, 1 to 10)
    assert(r4 == 80)
  }

  // #6
  test("test exercise 6: largestAt") {
    val r1 = largestAt(x => 10 * x - x * x, 1 to 10)
    println("r1: "+r1)
    assert(r1 == 5)
    val r2 = largestAt(x => 10 * x - x * 2, 1 to 10)
    println("r2: "+r2)
    assert(r2 == 10)
  }

  // #7
  test("test exercise 7: adjustToPair") {
    val pairs = 1 to 10 zip (11 to 20)
    println("pairs: "+pairs)
    val multPair = adjustToPair((x,y) => x * y) _
    val result = pairs map multPair
    println("result: "+result)
    val expected = Vector(11, 24, 39, 56, 75, 96, 119, 144, 171, 200)
    assert(result == expected)
  }

  // #8
  test("test exercise 8: correspondStringsAndLengths") {
    val strings = Array("Hello","world")
    val lengths = Array(5,5)
    println("strings: " + arrayToString(strings))
    println("lengths: " + arrayToString(lengths))
    assert(correspondStringsAndLengths(strings, lengths))
  }

}
