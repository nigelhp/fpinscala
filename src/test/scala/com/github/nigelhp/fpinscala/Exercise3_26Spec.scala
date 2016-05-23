package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_26.maximum

class Exercise3_26Spec extends FlatSpec {

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
}
