package sfti.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import sfti.exercises.Chapter6._

@RunWith(classOf[JUnitRunner])
class Chapter6Test extends FunSuite {

  test("test exercise #1 - Conversions object") {
    println("Conversions.inchesToCentimeters(12): "+Conversions.inchesToCentimeters(12))
    assert(Conversions.inchesToCentimeters(12) == 30.48)
    println("Conversions.gallonsToLiters(10): "+Conversions.gallonsToLiters(10))
    assert(Conversions.gallonsToLiters(10) == 37.854)
    println("Conversions.milesToKilometers(5): "+Conversions.milesToKilometers(5))
    assert(Conversions.milesToKilometers(5) == 8.0)
  }

  test("test exercise #2 - UnitConversion objects") {
    println("InchesToCentimeters.convert(12): "+InchesToCentimeters.convert(12))
    assert(InchesToCentimeters.convert(12) == 30.48)
    println("GallonsToLiters.convert(10): "+GallonsToLiters.convert(10))
    assert(GallonsToLiters.convert(10) == 37.854)
    println("MilesToKilometers.convert(5): "+MilesToKilometers.convert(5))
    assert(MilesToKilometers.convert(5) == 8.0)
  }

  test("test exercise #4 - Point class and companion object") {
    val p = Point(4,9)
    println("p.x: " + p.x)
    assert(p.x == 4)
    println("p.y: " + p.y)
    assert(p.y == 9)
  }

  test("test exercise #6 - PlayingCardSuit enumeration") {
    println("PlayingCardSuit.Club: " + PlayingCardSuit.Club)
    println("PlayingCardSuit.Diamond: " + PlayingCardSuit.Diamond)
    println("PlayingCardSuit.Heart: " + PlayingCardSuit.Heart)
    println("PlayingCardSuit.Spade: " + PlayingCardSuit.Spade)
  }

  test("test exercise #7 - PlayingCardSuit.isRed method") {
    println("PlayingCardSuit.isRed(PlayingCardSuit.Club): " +
      PlayingCardSuit.isRed(PlayingCardSuit.Club))
    assert(!PlayingCardSuit.isRed(PlayingCardSuit.Club))
    println("PlayingCardSuit.isRed(PlayingCardSuit.Diamond): " +
      PlayingCardSuit.isRed(PlayingCardSuit.Diamond))
    assert(PlayingCardSuit.isRed(PlayingCardSuit.Diamond))
    println("PlayingCardSuit.isRed(PlayingCardSuit.Heart): " +
      PlayingCardSuit.isRed(PlayingCardSuit.Heart))
    assert(PlayingCardSuit.isRed(PlayingCardSuit.Heart))
    println("PlayingCardSuit.isRed(PlayingCardSuit.Spade): " +
      PlayingCardSuit.isRed(PlayingCardSuit.Spade))
    assert(!PlayingCardSuit.isRed(PlayingCardSuit.Spade))
  }

}
