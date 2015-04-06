package sfti.exercises

import collection._
import scala.math
import sfti.exercises.Util._

/*
  Exercises to do (8): 1, 2, 3, 4, 5, 6, 7, 8
 */
object Chapter12 {

  val nonWordCharset = Set(',', '?', '.')

  /* 1) Write a function values( fun: (Int) = > Int, low: Int, high: Int) that
        yields a collection of function inputs and outputs in a given range.
        For example, values( x = > x * x, -5, 5) should produce a collection of
        pairs (-5, 25), (-4, 16), (-3, 9), . . ., (5, 25). */
  def values(fun: (Int) => Int, low: Int, high: Int): Seq[(Int,Int)] = {
    (low to high).map(i => (i, fun(i)))
  }

  /* 2) How do you get the largest element of an array with reduceLeft? */
  def largestFromReduceLeft(arr:Array[Int]): Int = {
    arr.reduceLeft((acc, i) => acc max i)
  }

  /* 3) Implement the factorial function using to and reduceLeft, without a loop
        or recursion. */
  def factorialFromToAndReduceLeft(num:Int): Int = {
    if (num == 0) 1
    else (1 to math.abs(num)).toList.reduceLeft((acc, i) => acc * i) * signum(num)
  }

  /* 4) The previous implementation needed a special case when n < 1. Show how
        you can avoid this with foldLeft.
        [Cary] This isn't actually true unless I'm missing something, because
        0! = 1 but 1 * 0 = 0 */
  def factorialFromFoldLeft(num:Int): Int = {
    if (num == 0) 1
    else (1 to math.abs(num)).foldLeft(1)((acc, i) => acc * i) * signum(num)
  }

  /* 5) Write a function largest(fun: (Int) => Int, inputs: Seq[Int]) that
        yields the largest value of a function within a given sequence of
        inputs. For example, largest(x => 10 * x - x * x, 1 to 10) should return
        25. Don't use a loop or recursion. */
  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.reduceLeft((acc, i) => acc max fun(i))
  }

  def largest2(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.map(fun).max
  }

  /* 6) Modify the previous function to return the input at which the output is
        largest. For example, largestAt(x => 10 * x - x * x, 1 to 10) should
        return 5. Don't use a loop or recursion. */
  def largestAt(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.reduceLeft((acc, i) => if (fun(acc) > fun(i)) acc else i)
  }

  /* 7) Write a function adjustToPair that receives a function of type
        (Int, Int) => Int and returns the equivalent function that operates on
        a pair. For example, adjustToPair(_ * _)((6,7)) is 42.
        largestAt(x => 10 * x - x * x, 1 to 10) should return 5. Don't use a
        loop or recursion. */
  def adjustToPair(fun: (Int, Int) => Int)(pair: (Int,Int)): Int = {
    fun(pair._1, pair._2)
  }

  /* 8) Make a call to corresponds that checks whether the elements in an array
        of strings have the lengths given in an array of integers. */
  def correspondStringsAndLengths(strings:Array[String], lengths:Array[Int]):
    Boolean = {
    strings.corresponds(lengths)(_.length == _)
  }
}