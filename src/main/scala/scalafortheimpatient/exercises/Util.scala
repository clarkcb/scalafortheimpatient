package sfti.exercises

import scala.collection.Map

object Util {
  def arrayToString[T](arr:Array[T]): String = {
    arr.mkString("Array(",",",")")
  }

  def printMap[A,B](map:Map[A,B]) {
    for ((k,v) <- map) println(k + " -> " + v)
  }

  def signum(i: Int): Int = i match {
    case n if n > 0 => 1
    case n if n < 0 => -1
    case _ => 0
  }
}
