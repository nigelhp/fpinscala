package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_9.length

class Exercise3_9Spec extends FlatSpec {

  "length" should "return 0 when the list is empty" in {
    assert(length(Nil) === 0)
  }

  it should "return 1 when the list contains a single element" in {
    assert(length(List(42)) === 1)
  }
  
  it should "return n when the list contains n elements" in {
    assert(length(List(1, 2, 3)) === 3)
  }
}
