import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_27.pathLength

class Exercise3_27Spec extends FlatSpec {

  "pathLength" should "return 1 when the tree contains only a single leaf node" in {
    val tree = Leaf("a")

    assert(pathLength(tree) === 1)
  }

  it should "return 2 when the tree consists of a branch having two leaf nodes" in {
    val tree = Branch(Leaf("a"), Leaf("b"))

    assert(pathLength(tree) === 2)
  }

  it should "return the longest path length in an unbalanced tree" in {
    val tree = Branch(Branch(Leaf("a"), Branch(Leaf("b"), Leaf("c"))), Leaf("d"))

    assert(pathLength(tree) === 4)
  }

  it should "return the longest path length in a balanced tree" in {
    val tree = Branch(Branch(Leaf("a"), Leaf("b")), Branch(Leaf("c"), Leaf("d")))

    assert(pathLength(tree) === 3)
  }
}
