package scalafortheimpatient.exercises

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scalafortheimpatient.exercises.Chapter14._

@RunWith(classOf[JUnitRunner])
class Chapter14Test extends FunSuite {

  test("test exercise 2: swapPair") {
    val pair = (1,2)
    println("pair: "+pair)
    val swapped = swapPair(pair)
    println("swapped: "+swapped)
    val expected = (2,1)
    println("expected: "+expected)
    assert(swapped == expected)
  }

  test("test exercise 3: swapFirstTwo") {
    // empty array
    val arr0 = Array.empty[Int]
    println("arr0: "+Util.arrayToString[Int](arr0))
    val swapped0 = swapFirstTwo(arr0)
    println("swapped0: "+Util.arrayToString[Int](swapped0))
    val expected0 = Array.empty[Int]
    println("expected0: "+Util.arrayToString[Int](expected0))
    assert(swapped0 === expected0)

    // one-elem array
    val arr1 = Array(1)
    println("arr1: "+Util.arrayToString[Int](arr1))
    val swapped1 = swapFirstTwo(arr1)
    println("swapped1: "+Util.arrayToString[Int](swapped1))
    val expected1 = Array(1)
    println("expected1: "+Util.arrayToString[Int](expected1))
    assert(swapped1 === expected1)

    // two-elem array
    val arr2 = Array(1,2)
    println("arr2: "+Util.arrayToString[Int](arr2))
    val swapped2 = swapFirstTwo(arr2)
    println("swapped2: "+Util.arrayToString[Int](swapped2))
    val expected2 = Array(2,1)
    println("expected2: "+Util.arrayToString[Int](expected2))
    assert(swapped2 === expected2)

    // three-elem array
    val arr3 = Array(1,2,3)
    println("arr3: "+Util.arrayToString[Int](arr3))
    val swapped3 = swapFirstTwo(arr3)
    println("swapped3: "+Util.arrayToString[Int](swapped3))
    val expected3 = Array(2,1,3)
    println("expected3: "+Util.arrayToString[Int](expected3))
    assert(swapped3 === expected3)
  }

  test("test exercise 3.2: swapFirstTwo2") {
    // empty array
    val arr0 = Array.empty[Int]
    println("arr0: "+Util.arrayToString[Int](arr0))
    val swapped0 = swapFirstTwo2(arr0)
    println("swapped0: "+Util.arrayToString[Int](swapped0))
    val expected0 = Array.empty[Int]
    println("expected0: "+Util.arrayToString[Int](expected0))
    assert(swapped0 === expected0)

    // one-elem array
    val arr1 = Array(1)
    println("arr1: "+Util.arrayToString[Int](arr1))
    val swapped1 = swapFirstTwo2(arr1)
    println("swapped1: "+Util.arrayToString[Int](swapped1))
    val expected1 = Array(1)
    println("expected1: "+Util.arrayToString[Int](expected1))
    assert(swapped1 === expected1)

    // two-elem array
    val arr2 = Array(1,2)
    println("arr2: "+Util.arrayToString[Int](arr2))
    val swapped2 = swapFirstTwo2(arr2)
    println("swapped2: "+Util.arrayToString[Int](swapped2))
    val expected2 = Array(2,1)
    println("expected2: "+Util.arrayToString[Int](expected2))
    assert(swapped2 === expected2)

    // three-elem array
    val arr3 = Array(1,2,3)
    println("arr3: "+Util.arrayToString[Int](arr3))
    val swapped3 = swapFirstTwo2(arr3)
    println("swapped3: "+Util.arrayToString[Int](swapped3))
    val expected3 = Array(2,1,3)
    println("expected3: "+Util.arrayToString[Int](expected3))
    assert(swapped3 === expected3)
  }

  test("test exercise 5: listAnyLeafSum") {
    val lstAny = List(List(1, 2), 3, List(4, 5), 6, 7, List(8, 9))
    println("lstAny: "+lstAny)
    val lstAnySum = listAnyLeafSum(lstAny)
    println("lstAnySum: "+lstAnySum)
    val expected = 45
    println("expected: "+expected)
    assert(lstAnySum == expected)
  }

  test("test exercise 6: binaryTreeLeafSum") {
    val tree:BinaryTree =
      BinNode(
        BinNode(
          BinNode(BinLeaf(1), BinLeaf(2)), BinLeaf(3)),
        BinNode(
          BinNode(BinLeaf(4), BinLeaf(5)), BinLeaf(6)))
    println("tree: "+tree)
    val treeSum = binaryTreeLeafSum(tree)
    println("treeSum: "+treeSum)
    val expected = 21
    println("expected: "+expected)
    assert(treeSum == expected)
  }

  test("test exercise 7: binaryTree2LeafSum") {
    val tree:VariableNodeTree =
      VarNode(
        VarNode(
          VarLeaf(1), VarLeaf(2), VarLeaf(3)),
        VarLeaf(4),
        VarLeaf(5),
        VarNode(
          VarLeaf(6),
          VarLeaf(7)),
        VarNode(
          VarNode(
            VarLeaf(8), VarLeaf(9)))
      )
    println("tree: "+tree)
    val treeSum = varNodeTreeLeafSum(tree)
    println("treeSum: "+treeSum)
    val expected = 45
    println("expected: "+expected)
    assert(treeSum == expected)
  }

  test("test exercise 8: binaryTree3LeafSum") {
    val tree:OpNodeTree =
      OpNode('+',
        OpNode('*', OpLeaf(3), OpLeaf(8)),
        OpLeaf(2),
        OpNode('-', OpLeaf(5)))
    println("tree: "+tree)
    val treeSum = eval(tree)
    println("treeSum: "+treeSum)
    val expected = 21
    println("expected: "+expected)
    assert(treeSum == expected)
  }

  test("test exercise 9: optIntSum") {
    val optInts = List(
      Some(1), None, Some(2), None, Some(3), None, Some(4), None, Some(5), None
    )
    println("optInts: "+optInts)
    val optSum = optIntSum(optInts)
    println("optSum: "+optSum)
    val expected = 15
    println("expected: "+expected)
    assert(optSum == expected)
  }

  test("test exercise 10: composeFunctions") {
    def f(x: Double) = if (x >= 0) Some(math.sqrt(x)) else None
    def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
    val f2 = compose2(f, g)
    val f22 = f2(2)
    println("f2(2): "+f22)
    assert(f22.isDefined)
    val f21 = f2(1)
    println("f2(1): "+f21)
    assert(!f21.isDefined)
    val f20 = f2(0)
    println("f2(0): "+f20)
    assert(f20.isDefined)

    val h = composeFunctions(f, g)
    val h2 = h(2)
    println("h(2): "+h2)
    assert(h2.isDefined)
    val h1 = h(1)
    println("h(1): "+h1)
    assert(!h1.isDefined)
    val h0 = h(0)
    println("h(0): "+h0)
    assert(h0.isDefined)
    println("f0(2): "+composeFunctions()(2))
  }
}
