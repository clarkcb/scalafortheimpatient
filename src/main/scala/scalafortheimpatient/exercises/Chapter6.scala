package sfti.exercises

/*
  Exercises to do (8): 1, 2, 3, 4, 5, 6, 7, 8
 */
object Chapter6 {
  /* 1) Write an object Conversions with methods inchesToCentimeters,
        gallonsToLiters, and milesToKilometers. */
  object Conversions {
    def inchesToCentimeters(inches:Double): Double = {
      inches * 2.54
    }
    def gallonsToLiters(gallons:Double): Double = {
      gallons * 3.7854
    }
    def milesToKilometers(miles:Double): Double = {
      miles * 1.6
    }
  }

  /* 2) Provide a general superclass UnitConversion and define objects
       InchesToCentimeters... */
  abstract class UnitConversion {
    def convert(in:Double): Double
  }

  object InchesToCentimeters extends UnitConversion {
    def convert(inches:Double): Double = {
      inches * 2.54
    }
  }

  object GallonsToLiters extends UnitConversion {
    def convert(gallons:Double): Double = {
      gallons * 3.7854
    }
  }

  object MilesToKilometers extends UnitConversion {
    def convert(miles:Double): Double = {
      miles * 1.6
    }
  }

  /* 3) Define an Origin object that extends java.awt.Point. Why is this not
        actually a good idea? (Have a close look at the methods of the Point
        class.)

     ANSWER: the Point class has methods to change the coordinates.
   */


  /* 4) Define a Point class with a companion object so that you can construct
        Point instances as Point(3, 4) without using new. */
  class Point(val x:Int, val y:Int) {}

  object Point {
    def apply(x:Int, y:Int): Point = {
      new Point(x, y)
    }
  }

  /* 5) Write a Scala application, using the App trait, that prints the
        command-line arguments in reverse order, separated by spaces. For
        example, scala Reverse Hello World should print World Hello. */
  object Reverse extends App {
    println(args.reverse.mkString(" "))
  }

  /* 6) Write an enumeration describing the four playing card suits so that the
        toString method returns ♣, ♦, ♥, or ♠. */
  object PlayingCardSuit extends Enumeration {
    type PlayingCardSuit = Value
    val Club = Value("\u2663")
    val Diamond = Value("\u2666")
    val Heart = Value("\u2665")
    val Spade = Value("\u2660")

    /* 7) Implement a function that checks whether a card suit value from the
          preceding exercise is red. */
    private val reds = Set(Heart, Diamond)
    def isRed(s: PlayingCardSuit):Boolean = {
      reds.contains(s)
    }
  }
}