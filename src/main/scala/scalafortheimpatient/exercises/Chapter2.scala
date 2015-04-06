package sfti.exercises

object Chapter2 {
  /* 1) The signum of a number is 1 if the number is positive, -1 if the number
        is negative, and 0 if the number is zero. 
  */
	def signum(i: Int): Int = i match {
    case n if n > 0 => 1
    case n if n < 0 => -1
    case _ => 0
  }

  /* 4) Write a Scala equivalent for Java loop:
        for (int i = 10; i >=0; i--) System.out.println(i);
  */
  def scalaForJavaLoop() {
    for (i <- 10 to 0 by -1) println(i)
  }

  /* 5) Write a procedure countdown(n: Int) that prints the number from n to 0 */
  def countdown(n: Int) {
    for (i <- n to 0 by -1) println(i)
  }

  /* 6,8) Write a for loop for computing the product of the Unicode codes of all
        letters in a string.
  */
  def unicodeProductLoop(s: String): Long = {
    var product = 1L
    for (c <- s) product *= c.toLong
    product
  }

  /* 7,8) Solve the preceding exercise without writing a loop. */
  def unicodeProductNoLoop(s: String): Long = {
    s.foldLeft(1L)(_ * _)
  }

  /* 9) Make the function of the previous exercise a recursive function. */
  def recUnicodeProduct(s: String): Long = {
    s.length match {
      case 0 => 1L
      case _ => s.head.toLong * recUnicodeProduct(s.drop(1))
    }
  }

  /* 9) Alternate solution 1 */
  def recUnicodeProduct2(s : String): Long = {
    if (s.length==0) 1
    else s(0).toLong * recUnicodeProduct2(s.drop(1))
  }

  /* 9) Alternate solution 2 */
  def recUnicodeProduct3(s: String): Long = {
    s.headOption match {
      case None => 1L
      case Some(c) => c.toLong * recUnicodeProduct3(s.drop(1))
    }
  }

  /* 10) Write a function that computes x^n, where n is an integer. Use the
         following recursive definition:
         *  x^n = y^2 if n is even and positive, where y = x^(n/2).
         *  x^n = x * x^(n-1) if n is odd and positive.
         *  x^0 = 1.
         *  x^n = 1/x^-n if n is negative.
        Don't use a return statement.
  */
  def xPowN(x: Double, n: Int): Double = n match {
    case _ if n > 0 && n % 2 == 0 => math.pow(xPowN(x, n / 2), 2)
    case _ if n > 0 => x * xPowN(x, n - 1)
    case _ if n == 0 => 1
    case _ if n < 0 => 1 / xPowN(x, -n)
  }

  def main(args: Array[String]) {

    // Exercising methods that aren't assertable, assertable methods tested in
    // Chapter2Test object

    println("Exercise 4: scalaForJavaLoop")
    scalaForJavaLoop()
    println()

    println("Exercise 5: countdown")
    println("countdown(11):")
    countdown(11)
    println()
  }
}