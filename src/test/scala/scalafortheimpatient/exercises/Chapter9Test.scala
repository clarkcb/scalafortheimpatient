package sfti.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import sfti.exercises.Chapter9._

@RunWith(classOf[JUnitRunner])
class Chapter9Test extends FunSuite {

  val fileWithTabsPath = "/filewithtabs.txt"
  val testPropertiesPath = "/test.properties"

  // #1
  test("test reverseFileLines") {
    reverseFileLinesFromInputStream(getClass.getResourceAsStream(testPropertiesPath),
    new java.io.File(testPropertiesPath).getName, "/tmp")
  }

  test("test tabsToSpaces") {
    tabsToSpacesFromInputStream(getClass.getResourceAsStream(fileWithTabsPath),
    new java.io.File(testPropertiesPath).getName, "/tmp", 4)
  }

  // #2
}
