import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_25.size

class Exercise3_25Spec extends FlatSpec {

  "size" should "return 1 when the tree contains a single leaf" in {
    val tree = Leaf("a")

    assert(size(tree) === 1)
  }

  it should "return 3 for a branch having both left and right leaf nodes" in {
    val tree = Branch(Leaf("a"), Leaf("b"))

    assert(size(tree) === 3)
  }

  it should "return the number of nodes in an unbalanced tree" in {
    val tree = Branch(Branch(Leaf("d"), Branch(Leaf("e"), Leaf("f"))), Leaf("c"))

    assert(size(tree) === 7)
  }

  it should "return the number of nodes in a balanced tree" in {
    val tree = Branch(Branch(Leaf("a"), Leaf("b")), Branch(Leaf("c"), Leaf("d")))

    assert(size(tree) === 7)
  }
}
