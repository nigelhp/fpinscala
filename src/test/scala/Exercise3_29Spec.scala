import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_29._

class Exercise3_29Spec extends FlatSpec {

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

  "maximum" should "return the leaf's value when the tree consists of a single node" in {
    val tree = Leaf(42)

    assert(maximum(tree) === 42)
  }

  it should "return the maximum value when the tree consists of a branch having two leaf nodes" in {
    val tree = Branch(Leaf(1), Leaf(2))

    assert(maximum(tree) === 2)
  }

  it should "return the maximum value in an unbalanced tree" in {
    val tree = Branch(Branch(Leaf(42), Branch(Leaf(1), Leaf(2))), Leaf(3))

    assert(maximum(tree) === 42)
  }

  it should "return the maximum value in a balanced tree" in {
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

    assert(maximum(tree) === 4)
  }

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

  "map" should "return a new leaf node when applied to a leaf node" in {
    val tree = Leaf(2)

    assert(map(tree)(n => n * n) === Leaf(4))
  }

  it should "return a new branch having two leaf nodes when applied to a branch having two leaf nodes" in {
    val tree = Branch(Leaf(2), Leaf(3))

    assert(map(tree)(n => n * n) === Branch(Leaf(4), Leaf(9)))
  }

  it should "return a new unbalanced tree when applied to an unbalanced tree" in {
    val intTree = Branch(Branch(Leaf(4), Branch(Leaf(1), Leaf(2))), Leaf(3))

    val charTree = map(intTree)(n => (96 + n).toChar)

    assert(charTree === Branch(Branch(Leaf('d'), Branch(Leaf('a'), Leaf('b'))), Leaf('c')))
  }

  it should "return a new balanced tree when applied to a balanced tree" in {
    val intTree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

    val charTree = map(intTree)(n => (96 + n).toChar)

    assert(charTree === Branch(Branch(Leaf('a'), Leaf('b')), Branch(Leaf('c'), Leaf('d'))))
  }
}
