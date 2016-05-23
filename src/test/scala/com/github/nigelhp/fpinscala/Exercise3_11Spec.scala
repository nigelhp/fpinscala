package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_11.{length, product, sum}

class Exercise3_11Spec extends FlatSpec {

  "sum" should "return 0 when the list is empty" in {
    assert(sum(Nil) === 0)
  }

  it should "return the element when the list contains a single element" in {
    assert(sum(List(42)) === 42)
  }

  it should "return the sum of all elements when the list contains multiple elements" in {
    assert(sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9)) === 45)
  }

  "product" should "return 1 when the list is emtpy" in {
    assert(product(Nil) === 1)
  }

  it should "return the element when the list contains a single element" in {
    assert(product(List(42)) === 42)
  }

  it should "return the product of all elements when the list contains multiple elements" in {
    assert(product(List(1, 2, 3, 4, 5, 6, 7, 8, 9)) === 362880)
  }

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
