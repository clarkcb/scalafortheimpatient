package sfti.exercises

import collection._
import java.util.Scanner
import scala.annotation.tailrec

/*
  Exercises to do (10): 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 */
object Chapter4 {

  val nonWordCharset = Set(',', '?', '.')

  def getDiscountedValue(value:Double, discount:Double): Double = {
    value - value * discount
  }

  /* 1) Set up a map of prices for a number of gizmos that you covet. Then
        produce a second map with the same keys and the prices at a 10 percent
        discount */
  def priceMapToDiscountMap(priceMap: Map[String, Double], discount:Double=0.1):
    Map[String, Double] = {
    val discountMap =
      for ((k,v) <- priceMap) yield (k, getDiscountedValue(v, discount))
    discountMap
  }

  // use map to produce the new Map
  def priceMapToDiscountMap2(priceMap: Map[String, Double], discount:Double):
    Map[String, Double] = {
    val discountMap = priceMap.map {
      kv =>
        (kv._1, getDiscountedValue(kv._2, discount))
    }
    discountMap
  }

  // get Scanner for file name (for 2, 3, 4, 5)
  def getScannerForFile(fileName:String): Scanner = {
    import java.io.File
    import java.net.URI
    val filePath = getClass.getResource("/"+fileName).toString
    val file = new File(new URI(filePath))
    new Scanner(file)
  }

  // print wordFreqs map (for 2, 3, 4, 5)
  def printWordFreqs(wordFreqs:Map[String,Int]) {
    val longestLength = wordFreqs.keySet.foldLeft(0)((len,word) =>
      if (word.length > len) word.length else len)
    val formatString = " %1$-"+longestLength+"s  %2$2d"
    for ((word,freq) <- wordFreqs) {
      println(formatString.format(word, freq))
    }
  }

  /* 2) Write a program that reads words from a file. Use a mutable map to count
        how often each word appears. To read the words, simply use a
        java.util.Scanner */
  def mutableMapWordFreqs(fileName:String): mutable.Map[String,Int] = {
    val in = getScannerForFile(fileName)
    val wordFreqs = mutable.Map[String,Int]()
    while (in.hasNext) {
      val word = in.next.filterNot(nonWordCharset.contains)
      wordFreqs(word) = wordFreqs.getOrElse(word, 0) + 1
    }
    wordFreqs
  }

  /* 3) Repeat the preceding exercise with an immutable map. */
  def immutableMapWordFreqs(fileName:String): immutable.Map[String,Int] = {
    val in = getScannerForFile(fileName)
    val wordFreqs = mutable.Map[String,Int]()
    while (in.hasNext) {
      val word = in.next.filterNot(nonWordCharset.contains)
      val freq = wordFreqs.getOrElse(word, 0)
      wordFreqs += (word -> (freq + 1))
    }
    immutable.Map.empty[String,Int] ++ wordFreqs
  }

  /* 3) using recursion */
  def immutableMapWordFreqs2(fileName:String): immutable.Map[String,Int] = {
    val in = getScannerForFile(fileName)
    @tailrec
    def recGetWordFreqs(in:Scanner, wordFreqs:immutable.Map[String,Int]):
      immutable.Map[String,Int] = {
      if (!in.hasNext) wordFreqs
      else {
        val word = in.next.filterNot(nonWordCharset.contains)
        val freq = wordFreqs.getOrElse(word, 0)
        recGetWordFreqs(in, wordFreqs + (word -> (freq + 1)))
      }
    }
    recGetWordFreqs(in, immutable.Map.empty[String,Int])
  }

  /* 4) Repeat the preceding exercise with a sorted map, so that the words are
        printed in sorted order. */
  def sortedMapWordFreqs(fileName:String): immutable.SortedMap[String,Int] = {
    val in = getScannerForFile(fileName)
    var wordFreqs = immutable.SortedMap[String,Int]()
    while (in.hasNext) {
      val word = in.next.filterNot(nonWordCharset.contains)
      val freq = wordFreqs.getOrElse(word, 0)
      wordFreqs = wordFreqs + (word -> (freq + 1))
    }
    wordFreqs
  }

  /* 4) using recursion */
  def sortedMapWordFreqs2(fileName:String):immutable.SortedMap[String,Int] = {
    val in = getScannerForFile(fileName)
    def recGetWordFreqs(in:Scanner, wordFreqs:immutable.SortedMap[String,Int]):
      immutable.SortedMap[String,Int] = {
      if (!in.hasNext) wordFreqs
      else {
        val word = in.next.filterNot(nonWordCharset.contains)
        val freq = wordFreqs.getOrElse(word, 0)
        recGetWordFreqs(in, wordFreqs + (word -> (freq + 1)))
      }
    }
    recGetWordFreqs(in, immutable.SortedMap.empty[String,Int])
  }

  /* 5) Repeat the preceding exercise with a java.util.TreeMap that you adapt to
        the Scala API. */
  def treeMapWordFreqs(fileName:String): java.util.TreeMap[String,Int] = {
    import collection.JavaConversions.mapAsScalaMap
    val in = getScannerForFile("hello.txt")
    val wordFreqs = new java.util.TreeMap[String,Int]
    while (in.hasNext) {
      val word = in.next.filterNot(nonWordCharset.contains)
      val freq = wordFreqs.getOrElse(word, 0)
      wordFreqs.put(word, freq + 1)
    }
    wordFreqs
  }

  /* 6) Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY,
        and similarly for other weekdays. Demonstrate that the elements are
        visited in insertion order. */
  val weekdayMap = mutable.LinkedHashMap(
    "Monday" -> java.util.Calendar.MONDAY,
    "Tuesday" -> java.util.Calendar.TUESDAY,
    "Wednesday" -> java.util.Calendar.WEDNESDAY,
    "Thursday" -> java.util.Calendar.THURSDAY,
    "Friday" -> java.util.Calendar.FRIDAY,
    "Saturday" -> java.util.Calendar.SATURDAY,
    "Sunday" -> java.util.Calendar.SUNDAY
  )

  /* 7) Print a table of all Java properties... */
  def printJavaProperties() {
    import collection.JavaConversions.propertiesAsScalaMap
    val props = System.getProperties
    val propKeys = props.keySet.toArray.toList.asInstanceOf[List[String]].
      sortWith(_ < _)
    println("Java properties:")
    val longestLength = propKeys.foldLeft(0)((len,word) =>
      if (word.length > len) word.length else len)
    val formatString = " %1$-"+longestLength+"s  %2$s"
    propKeys foreach (k => println(formatString.format(k, props(k))))
  }

  /* 8) Write a function minmax(values: Array[Int]) that returns a pair
        containing the smallest and largest values in the array */
  def minmax(values: Array[Int]): (Int,Int) = {
    (values.min, values.max)
  }

  /* 9) Write a function lteqgt( values: Array[ Int], v: Int) that returns a
        triple containing the counts of values less than v, equal to v, and
        greater than v. */
  def lteqgt(values: Array[Int], v: Int): (Int,Int,Int) = {
    val (gt,others) = values.partition(_ > v)
    val (lt,eq) = others.partition(_ < v)
    (lt.length, eq.length, gt.length)
  }

  /* 10) See what happens when you zip two strings together */
  def zipStrings(s1: String, s2: String): String = {
    s1.zip(s2).map(s => "%s%s".format(s._1, s._2)).mkString
  }
}