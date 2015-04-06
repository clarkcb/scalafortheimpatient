package sfti.exercises

import scala.collection.mutable

/*
  Exercises to do (8): 1, 2, 3, 4, 5, 6, 7, 8
 */
object Chapter13 {

  val nonWordCharset = Set(',', '?', '.')

  /* 1) Write a function that, given a string, produces a map of the indexes of
        all characters. For example, indexes(" Mississippi") should return a map
        associating 'M' with the set {0}, 'i' with the set {1, 4, 7, 10}, and so
        on. Use a mutable map of characters to mutable sets. How can you ensure
        that the set is sorted? */
  def mutableIndexMap(s:String): mutable.Map[Char, mutable.LinkedHashSet[Int]] = {
    val map = mutable.Map.empty[Char, mutable.LinkedHashSet[Int]]
    0 until s.length foreach {
      i =>
        map(s(i)) = map.getOrElse(s(i), mutable.LinkedHashSet.empty[Int]) + i
    }
    map
  }

  /* 2) Repeat the preceding exercise, using an immutable map of characters to
        lists. */
  def immutableIndexMap(s:String): Map[Char, List[Int]] = {
    def recIndexMap(cis:Seq[(Char,Int)], charMap:Map[Char, List[Int]]):
      Map[Char, List[Int]] = cis match {
      case Nil => charMap
      case _ =>
        val (c,i) = cis.head
        val newEntry: (Char, List[Int]) =
          (c, charMap.getOrElse(c, List.empty[Int]) ++ List(i))
        recIndexMap(cis.tail, charMap + newEntry)
    }
    recIndexMap(s.zipWithIndex, Map.empty[Char, List[Int]])
  }

  // alternate approach #1
  def immutableIndexMap1(s:String): Map[Char, List[Int]] = {
    s.zipWithIndex.groupBy(_._1).map(x => (x._1, x._2.map(_._2).toList))
  }

  /* 3) Write a function that removes all zeroes from a linked list of integers. */
  def removeZeros(nums:List[Int]): List[Int] = nums.filterNot(_ == 0)

  /* 4) Write a function that receives a collection of strings and a map from
        strings to integers. Return a collection of integers that are values of
        the map corresponding to one of the strings in the collection. For
        example, given Array("Tom", "Fred", "Harry") and Map("Tom" -> 3,
        "Dick" -> 4, "Harry" -> 5), return Array(3, 5). Hint: Use flatMap to
        combine the Option values returned by get. */
  def stringIndices(strings:Iterable[String], stringMap:Map[String, Int]):
    Iterable[Int] = {
    strings.flatMap(s => stringMap.get(s))
  }

  /* 5) Implement a function that works just like mkString, using reduceLeft. */
  def reduceLeftMkString(seq:Seq[String], sep: String): String = {
    seq.reduceLeft((acc, a) => acc + sep + a)
  }

  /* 6) Given a list of integers lst, what is (lst :\ List[ Int]())(_ :: _)?
        (List[ Int]() /: lst)(_ :+ _)? How can you modify one of them to reverse
        the list? */
  def doListFolding(lst:List[Int]) {
    val one = (lst :\ List[Int]())(_ :: _)
    println("one: "+one)
    val oneRev = (lst :\ List[Int]())((e,l) => l :+ e)
    println("oneRev: "+oneRev)
    val two = (List[Int]() /: lst)(_ :+ _)
    println("two: "+two)
    val twoRev = (List[Int]() /: lst)((l,e) => e +: l)
    println("twoRev: "+twoRev)
  }

  /* 7) The expression (prices zip quantities) map { p = > p._1 * p._2 } is a
        bit inelegant. We can’t do (prices zip quantities) map { _ * _ } because
        _ * _ is a function with two arguments, and we need a function with one
        argument that is a tuple. The tupled method of the Function2 class
        changes a function with two arguments to one that takes a tuple. Apply
        tupled to the multiplication function so you can map it over the list
        of pairs. */
  def multiplyPairs(pairs:Seq[(Double,Double)]): Seq[Double] = {
    val multiplyTuple = ((x:Double, y:Double) => x * y).tupled
    pairs map multiplyTuple
  }

  /* 8) Write a function that turns an array of Double values into a two-
        dimensional array. Pass the number of columns as a parameter. For
        example, with Array(1, 2, 3, 4, 5, 6) and three columns, return
        Array(Array(1, 2, 3), Array( 4, 5, 6)). Use the grouped method. */
  def columnize(values:Array[Double], columns:Int): Array[Array[Double]] = {
    values.grouped(columns).toArray
  }

  /* 9) Harry Hacker writes a program that accepts a sequence of file names on
        the command line. For each, he starts a new thread that reads the file
        and updates a letter frequency map, declared as

        val frequencies = new scala.collection.mutable.HashMap[Char, Int] with
          scala.collection.mutable.SynchronizedMap[Char, Int]

        When reading a letter c, he calls

        frequencies(c) = frequencies.getOrElse(c, 0) + 1

        Why won’t this work? Will it work if he used instead

        import scala.collection.JavaConversions.asScalaConcurrentMap
        val frequencies: scala.collection.mutable.ConcurrentMap[Char, Int] =
          new java.util.concurrent.ConcurrentHashMap[Char, Int] */
  // Answer: I don't know
  //def getConcurrentMap[A,B]: mutable.ConcurrentMap[A,B] = {
  //  import scala.collection.JavaConversions.asScalaConcurrentMap
  //  val map: scala.collection.mutable.ConcurrentMap[A, B] = new java.util.concurrent.ConcurrentHashMap[A, B]
  //  map
  //}

  /* 10) Harry Hacker reads a file into a string and wants to use a parallel
         collection to update the letter frequencies concurrently on portions
         of the string. He uses the following code:

         val frequencies = new scala.collection.mutable.HashMap[Char, Int]
         for (c <- str.par) frequencies(c) = frequencies.getOrElse(c, 0) + 1

         Why is this a terrible idea? How can he really parallelize the
         computation? (Hint: Use aggregate.) */
  def getCharFrequencyMap(str:String): Map[Char,Int] = {
    str.par.aggregate(Map[Char,Int]())(
      (m,c) => m + (c -> (m.getOrElse(c, 0) + 1)),
      (map1, map2) => map1 ++ map2.map { case (k,v) => k -> (v + map1.getOrElse(k,0)) }
    )
  }
}