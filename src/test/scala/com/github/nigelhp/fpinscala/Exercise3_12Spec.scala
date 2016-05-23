package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_12.reverse

class Exercise3_12Spec extends FlatSpec {

  "reverse" should "return an empty list when the input list is empty" in {
    assert(reverse(Nil) === Nil)
  }

  it should "return an equivalent list when the input list contains a single element" in {
    assert(reverse(List(42)) === List(42))
  }

  it should "contain the same elements in reverse order when the input list contains multiple elements" in {
    assert(reverse(List(1, 2, 3)) === List(3, 2, 1))
  }
}
