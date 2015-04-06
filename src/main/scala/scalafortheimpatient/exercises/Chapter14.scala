package scalafortheimpatient.exercises

/*
  Exercises to do (9): 2, 3, 4, 5, 6, 7, 8, 9, 10
 */
object Chapter14 {

  val nonWordCharset = Set(',', '?', '.')

  /* 1) ... java src ... */


  /* 2) Using pattern matching, write a function swap that receives a pair of
        integers and returns the pair with the components swapped. */
  def swapPair(pair:(Int,Int)): (Int,Int) = pair match {
    case (x,y) => (y,x)
  }

  /* 3) Using pattern matching, write a function swap that swaps the first two
        elements of an array provided its length is at least two. */
  def swapFirstTwo(arr:Array[Int]): Array[Int] = arr match {
    case Array(x, y, _*) => Array(y,x) ++ arr.drop(2)
    case _ => arr
  }

  // alternative: explicitly check the length
  def swapFirstTwo2(arr:Array[Int]): Array[Int] = arr.length match {
    case n if n > 1 => Array(arr(1),arr(0)) ++ arr.drop(2)
    case _ => arr
  }

  // Colm's solution
  def swapFirstTwoColm(p:Array[Int]):Array[Int] = p.splitAt(2) match {//took awhile to figture out snytax
    case (Array(x,y) ,z) => Array(y,x) ++z
  }

  /* 4) Add a case class Multiple that is a subclass of the Item class. For
  example, Multiple( 10, Product(" Blackwell Toaster", 29.95)) describes ten
  toasters. Of course, you should be able to handle any items, such as bundles
  or multiples, in the second argument. Extend the price function to handle
  this new case. */
  // ...

  /* 5) Write a leafSum function to compute the sum of all elements in the
        leaves, using pattern matching to differentiate between numbers and
        lists. */
  def listAnyLeafSum(lst:List[Any]): Int = {
    lst.map {
      case i: Int => i
      case i: List[Any] => listAnyLeafSum(i)
    }.sum
  }

  /* 6) A better way of modeling such trees is with case classes. Let’s start
        with binary trees. Write a function to compute the sum of all elements
        in the leaves. */
  sealed abstract class BinaryTree
  case class BinLeaf(value: Int) extends BinaryTree
  case class BinNode(left: BinaryTree, right: BinaryTree) extends BinaryTree
  def binaryTreeLeafSum(tree:BinaryTree): Int = tree match {
    case l:BinLeaf => l.value
    case n:BinNode => binaryTreeLeafSum(n.left) + binaryTreeLeafSum(n.right)
  }

  /* 7) Extend the tree in the preceding exercise so that each node can have an
        arbitrary number of children, and reimplement the leafSum function. The
        tree in exercise 5 should be expressible as

        Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))  */
  sealed abstract class VariableNodeTree
  case class VarLeaf(value: Int) extends VariableNodeTree
  case class VarNode(trees: VariableNodeTree*) extends VariableNodeTree
  def varNodeTreeLeafSum(tree:VariableNodeTree): Int = tree match {
    case VarLeaf(x) => x
    case VarNode(trees @ _*) => trees.map(varNodeTreeLeafSum).sum
  }

  /* 8) Extend the tree in the preceding exercise so that each non-leaf node
        stores an operator in addition to the child nodes. Then write a function
        eval that computes the value. For example, the tree

              +
            / |  \
           *  2  -
         /  \    |
        3   8    5

        has the value (3 x 8) + 2 + (-5) = 21.
  */
  sealed abstract class OpNodeTree
  case class OpLeaf(value: Int) extends OpNodeTree
  case class OpNode(op: Char, trees: OpNodeTree*) extends OpNodeTree
  def eval(tree:OpNodeTree): Int = tree match {
    case OpLeaf(x) => x
    case OpNode(op, trees @ _*) => op match {
      case '+' => trees.map(eval).sum
      case '-' =>
        val res = trees.map(eval)
        val subseq = if (res.length > 1) res else 0 +: res
        subseq.reduceLeft(_ - _)
      case '*' => trees.map(eval).product
    }
  }

  /* 9) Write a function that computes the sum of the non-None values in a
        List[Option[Int]]. Don’t use a match statement. */
  def optIntSum(optInts:List[Option[Int]]): Int = {
    //optInts.map(_.sum).sum
    optInts.flatten.sum
  }

  /* 10) Write a function that composes two functions of type Double =>
         Option[Double], yielding another function of the same type. The
         composition should yield None if either function does. For example,

         def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
         def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None
         val h = compose(f, g)

         Then h(2) is Some(1), and h(1) and h(0) are None. */
  def compose2(f:Double => Option[Double], g:Double => Option[Double]):
    (Double) => Option[Double] = {
    (d:Double) => f(d) match {
      case None => None
      case Some(r) => g(r)
    }
  }

  // compose a variant number of functions
  def composeFunctions(funs:(Double => Option[Double])*): Double => Option[Double] = {
    (d:Double) => {
      def recResult(d:Double, funs:(Double => Option[Double])*): Option[Double] =
        funs.length match {
        case 0 => None
        case 1 => funs(0)(d)
        case _ => funs(0)(d) match {
          case Some(r) => recResult(r, funs.tail:_*)
          case None => None
        }
      }
      recResult(d, funs:_*)
    }
  }
}