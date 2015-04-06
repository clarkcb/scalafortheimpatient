package sfti.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import sfti.exercises.Chapter13._
import sfti.exercises.Util._

@RunWith(classOf[JUnitRunner])
class Chapter13Test extends FunSuite {

  // #1
  test("test exercise 1: mutableIndexMap") {
    val map = mutableIndexMap("Mississippi")
    println("map: " + map)
    val expected = Map(
      'i' -> Set(1, 4, 7, 10),
      'M' -> Set(0),
      's' -> Set(2, 6, 3, 5),
      'p' -> Set(9, 8))
    assert(map == expected)
  }

  // #2
  test("test exercise 2: immutableIndexMap") {
    val map2 = immutableIndexMap("Mississippi")
    println("map2: "+map2)
    val expected = Map(
      'i' -> List(1, 4, 7, 10),
      'M' -> List(0),
      's' -> List(2, 3, 5, 6),
      'p' -> List(8, 9))
    assert(map2 == expected)
  }

  // #3
  test("test exercise 3: removeZeros") {
    val withZeros = List(0,1,0,2,0,3,0,4,0,5,0,6,0,7,0,8,0,9)
    println("withZeros: "+withZeros)
    val noZeros = removeZeros(withZeros)
    println("noZeros: "+noZeros)
    val expected = List(1,2,3,4,5,6,7,8,9)
    assert(noZeros == expected)
  }

  // #4
  test("test exercise 4: stringIndices") {
    val strings = List("Tom", "Fred", "Harry")
    println("strings: "+strings)
    val stringMap = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
    println("stringMap: "+stringMap)
    val indices = stringIndices(strings, stringMap)
    println("indices: "+indices)
    val expected = List(3,5)
    assert(indices == expected)
  }

  // #5
  test("test exercise 5: reduceLeftMkString") {
    val strings = List("Tom", "Fred", "Harry")
    val names = List("Tom", "Fred", "Harry")
    println("names: "+names)
    val nameString = reduceLeftMkString(strings, " :: ")
    println("nameString: "+nameString)
    val expected = "Tom :: Fred :: Harry"
    assert(nameString == expected)
  }

  // #6
  test("test exercise 6: doListFolding") {
    val nums = List(1,2,3,4,5)
    println("nums: "+nums)
    doListFolding(nums)
  }

  // #7
  test("test exercise 7: multiplyPairs") {
    val prices = List(9.99, 20.00, 1.99)
    println("prices: "+prices)
    val quantities = List(2.0, 1.0, 4.0)
    println("quantities: "+quantities)
    val costs = multiplyPairs(prices zip quantities)
    println("costs: "+costs)
    val expected = List(19.98, 20.0, 7.96)
    assert(costs == expected)
  }

  // #8
  test("test exercise 8: columnize") {
    val arr1 = Array(9.99, 20.00, 1.99, 2.0, 1.0, 4.0)
    println("arr1 (%d): %s".format(arr1.length, arrayToString(arr1)))
    val arr12 = columnize(arr1, 2)
    val expectedArr12 = Array(Array(9.99, 20.0), Array(1.99, 2.0),
      Array(1.0, 4.0))
    println("arr12: "+arr12.map(arrayToString).mkString("Array(",", ",")"))
    println("expectedArr12: "+expectedArr12.map(arrayToString).
      mkString("Array(",", ",")"))
    assert(arr12 === expectedArr12)
    val arr13 = columnize(arr1, 3)
    val expectedArr13 = Array(Array(9.99, 20.0, 1.99), Array(2.0, 1.0, 4.0))
    println("arr13: "+arr13.map(arrayToString).mkString("Array(",", ",")"))
    println("expectedArr13: "+expectedArr13.map(arrayToString).
      mkString("Array(",", ",")"))
    assert(arr13 === expectedArr13)

    val arr2 = Array(9.99, 20.00, 1.99, 2.0, 1.0, 4.0, 7.0)
    println("arr2 (%d): %s".format(arr2.length, arrayToString(arr2)))
    val arr22 = columnize(arr2, 2)
    val expectedArr22 = Array(Array(9.99, 20.0), Array(1.99, 2.0),
      Array(1.0, 4.0), Array(7.0))
    println("arr22: "+arr22.map(arrayToString).
      mkString("Array(",", ",")"))
    println("expectedArr22: "+expectedArr22.map(arrayToString).
      mkString("Array(",", ",")"))
    assert(arr22 === expectedArr22)
    val arr23 = columnize(arr2, 3)
    val expectedArr23 = Array(Array(9.99, 20.0, 1.99), Array(2.0, 1.0, 4.0),
      Array(7.0))
    println("arr23: "+arr23.map(arrayToString).
      mkString("Array(",", ",")"))
    println("expectedArr23: "+expectedArr23.map(arrayToString).
      mkString("Array(",", ",")"))
    assert(arr23 === expectedArr23)
  }

}
