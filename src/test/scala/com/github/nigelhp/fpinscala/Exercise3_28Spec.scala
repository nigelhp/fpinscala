package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_28.map

class Exercise3_28Spec extends FlatSpec {

  "map" should "return a new leaf node when applied to a leaf node" in {
    val tree = Leaf(2)

    assert(map(tree)(n => n * n) === Leaf(4))
  }

  it should "return a new branch having two leaf nodes when applied to a branch having two leaf nodes" in {
    val tree = Branch(Leaf(2), Leaf(3))

    assert(map(tree)(n => n * n) === Branch(Leaf(4), Leaf(9)))
  }

  it should "return a new unbalanced tree when applied to an unbalanced tree" in {
    val tree = Branch(Branch(Leaf(4), Branch(Leaf(1), Leaf(2))), Leaf(3))

    val squaredTree = map(tree)(n => n * n)

    assert(squaredTree === Branch(Branch(Leaf(16), Branch(Leaf(1), Leaf(4))), Leaf(9)))
  }

  it should "return a new balanced tree when applied to a balanced tree" in {
    val tree = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))

    val incrementedTree = map(tree)(n => n + 1)

    assert(incrementedTree === Branch(Branch(Leaf(2), Leaf(3)), Branch(Leaf(4), Leaf(5))))
  }
}
