package sfti.exercises

/*
  Exercises to do (9): 1, 2, 3, 4, 5, 6, 7, 9, 10
 */

object Chapter3 {
  /* 1) Write a code snippet that sets a to an array of n random integers
        between 0 (inclusive) and n (exclusive) */
  def randomIntArray(n: Int): Array[Int] = {
    val rnd = new util.Random()
    val arr = for (i <- 0 until n) yield rnd.nextInt(n)
    arr.toArray
  }

  /* 2,3) Write a loop that swaps adjacent elements of an array of integers */
  def swapAdjacent(arr: Array[Int]): Array[Int] = arr.length match {
    case n if n < 2 => arr
    case _ => Array[Int](arr(1), arr(0)) ++ swapAdjacent(arr.drop(2))
  }

  /* 4) Given an array of integers, produce a new array that contains all
        positive values of the original array, in their original order,
        followed by all values that are zero or negative, in their original
        order. */
  def positiveThenNegative(a: Array[Int]): Array[Int] = {
    import scala.collection.mutable.ArrayBuffer
    val pos = ArrayBuffer[Int]()
    val neg = ArrayBuffer[Int]()
    for (i <- a) {
      if (i > 0) pos.append(i)
      else neg.append(i)
    }
    (pos ++ neg).toArray
  }

  /* 4a) Same as 4 but try using partition */
  def positiveThenNegativeByPartition(a: Array[Int]): Array[Int] = {
    val (pos, neg) = a.partition(_ > 0)
    (pos ++ neg).toArray
  }

  /* 5) How do you compute the average of an Array[Double]? */
  def computeAverageArrayDouble(a: Array[Double]): Double = {
    a.sum / a.length
  }

  /* 6) How do you rearrange the elements of an Array[ Int] so that they appear
        in reverse sorted order? How do you do the same with an
        ArrayBuffer[Int]? */
  def reverseArrayInt(a: Array[Int]): Array[Int] = {
    a.reverse
  }

  /* 7) Write a code snippet that produces all values from an array with
        duplicates removed. (Hint: Look at Scaladoc.) */
  def arrayNoDups[T](a:Array[T]): Array[T] = a.distinct

  /* 9) Make a collection of all time zones returned by
        java.util.TimeZone.getAvailableIDs that are in America.
        Strip off the "America/" prefix and sort the result. */
  def americanTimeZones: Array[String] = {
    java.util.TimeZone.getAvailableIDs.filter(_.startsWith("America/")).
      map(_.substring("America/".length)).sortWith(_ < _)
  }

  /* 10) Import java.awt.datatransfer._ and make an object of type
         SystemFlavorMap */
  def nativesForFlavor() {
    import java.awt.datatransfer._
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val flavorMap = flavors.getNativesForFlavors(Array(DataFlavor.imageFlavor))
    val flavorKeys = Array[DataFlavor]() ++ flavorMap.keySet.toArray
    for (k <- flavorKeys) {
      println(k.toString + ": " + flavorMap.get(k))
    }
  }

  def main(args: Array[String]) {
    println("Exercise 10: nativesForFlavor")
    nativesForFlavor()
    println()
  }
}