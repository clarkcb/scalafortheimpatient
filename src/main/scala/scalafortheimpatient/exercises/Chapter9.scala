package sfti.exercises

import java.io.File
import scala.io.Source
import java.io.{InputStream, FileInputStream, PrintWriter}

object Chapter9 {

  /* 1) Write a Scala code snippet that reverses the lines in a file (making the
        last line the first one, and so on). */

  def reverseFileLines(filePath:String) {
    reverseFileLinesFromInputStream(new FileInputStream(filePath),
      new File(filePath).getName, "/tmp")
  }

  def reverseFileLinesFromInputStream(fis:InputStream, fileName:String,
                                      outputPath:String) {
    val lines = Source.fromInputStream(fis).getLines().toArray
    val newFile = new File(new File(outputPath), "rev_"+fileName)
    val out = new PrintWriter(newFile)
    for (line <- lines.reverse) out.println(line)
    out.close()
  }

  /* 2) Write a Scala program that reads a file with tabs, replaces each tab
        with spaces so that tab stops are at n-column boundaries, and writes
        the result to the same file. */

  def tabsToSpaces(filePath:String, numSpaces:Int) {
    tabsToSpacesFromInputStream(new FileInputStream(filePath),
      new File(filePath).getName, "/tmp", numSpaces)
  }

  def tabsToSpacesFromInputStream(fis:InputStream, fileName:String,
                                  outputPath:String, numSpaces:Int) {
    val newFile = new File(new File(outputPath), "rev_"+fileName)
    val out = new PrintWriter(newFile)
    for (line <- Source.fromInputStream(fis).getLines()) {
      """\t""".r.replaceAllIn(line, " "*numSpaces)
      out.println(line)
    }
    out.close()
  }

  /* 3) Write a Scala code snippet that reads a file and prints all words with
        more than 12 characters to the console. Extra credit if you can do this
        in a single line. */

  def longWords(filePath:String) {
    Source.fromFile(filePath).getLines().map(_.split("""\s+""")).
      filter(_.length > 12).foreach(println(_))
  }

  /* 4) Write a Scala program that reads a text file containing only
        floating-point numbers. Print the sum, average, maximum, and minimum
        of the numbers in the file. */

  def floatFile(filePath:String) {
    val nums = Source.fromFile(filePath).getLines().map(_.split("""\s+""")).
      map(_.asInstanceOf[Double])
    println("nums: "+nums.mkString(" "))
    println("sum: "+nums.sum)
    println("average: " + nums.sum / nums.length)
    println("maximum: " + nums.max)
    println("minimum: " + nums.min)
  }


  /* 5) Write a Scala program that writes the powers of 2 and their reciprocals
        to a file, with the exponent ranging from 0 to 20. Line up the columns:
            1    1
            2    0.5
            4    0.25
  */

  def powersOf2() {

  }

  /* 6) Make a regular expression searching for quoted strings "like this, maybe with \" or \\" in a Java or C++
        program. Write a Scala program that prints out all such strings in a source file. */


  /* 7) Write a Scala program that reads a text file and prints all tokens in the file that are not floating-point
        numbers. Use a regular expression. */


  /* 8) Write a Scala program that prints the src attributes of all img tags of a web page. Use regular expressions
        and groups. */


  /* 9) Write a Scala program that counts how many files with .class extension are in a given directory and its
        subdirectories. */


  /* 10) Expand the example with the serializable Person class that stores a collection of friends. Construct a few
         Person objects, make some of them friends of another, and then save an Array[ Person] to a file. Read the
         array back in and verify that the friend relations are intact. */


  def main(args: Array[String]) {
  }
}