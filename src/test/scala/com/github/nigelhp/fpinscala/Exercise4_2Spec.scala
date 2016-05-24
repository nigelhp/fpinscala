package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import exercise4_1.{Some, None}
import Exercise4_2.variance

class Exercise4_2Spec extends FlatSpec {

  "variance" should "return None when the input sequence is empty" in {
    assert(variance(Nil) === None)
  }

  it should "return 0 when the list contains a single element" in {
    assert(variance(List(1)) === Some(0.0))
  }

  it should "return 0 when then list contains multiple elements of the same value" in {
    assert(variance(List(1, 1, 1, 1)) === Some(0.0))
  }

  it should "return 1 when the list consists of two elements either side of the mean" in {
    assert(variance(List(2, 4)) === Some(1.0))
  }

  // calculating variance of a popluation example from http://www.wikihow.com/Calculate-Variance
  it should "return the population variance when the list is not empty" in {
    assert(variance(List(5, 5, 8, 12, 15, 18)) === Some(24.25))
  }
}
