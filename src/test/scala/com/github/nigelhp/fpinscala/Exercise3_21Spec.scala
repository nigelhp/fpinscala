package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_21.filter

class Exercise3_21Spec extends FlatSpec {

  "filter" should "return an empty list when the input list is empty" in {
    assert(filter(Nil)(_ => true) === Nil)
  }

  it should "return an empty list when no values satisfy the predicate" in {
    assert(filter(List(1, 2, 3))(_ => false) === Nil)
  }

  it should "return the original list when all values satisfy the predicate" in {
    assert(filter(List(1, 2, 3))(_ => true) === List(1, 2, 3))
  }

  it should "be able to remove all odd numbers from a List[Int]" in {
    assert(filter(List(1, 2, 3, 4, 5, 6, 7, 8))(i => i % 2 == 0) === List(2, 4, 6, 8))
  }
}
