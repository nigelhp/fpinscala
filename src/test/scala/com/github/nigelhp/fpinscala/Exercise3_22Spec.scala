package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_22.zipAdd

class Exercise3_22Spec extends FlatSpec {

  "zipAdd" should "return an empty list when both input lists are empty" in {
    assert(zipAdd(Nil, Nil) === Nil)
  }

  it should "return an empty list when the first input list is empty" in {
    assert(zipAdd(Nil, List(1, 2, 3)) === Nil)
  }

  it should "return an empty list when the second input list is empty" in {
    assert(zipAdd(List(1, 2, 3), Nil) === Nil)
  }

  it should "return a list containing the sum of the head of both input lists when both lists contain a single element" in {
    assert(zipAdd(List(1), List(2)) === List(3))
  }

  it should "return a list of the sum of corresponding elements when both lists have the same length" in {
    assert(zipAdd(List(1, 2, 3), List(4, 5, 6)) === List(5, 7, 9))
  }

  it should "return a list of the sum of corresponding elements having a length matching that of the shortest input list" in {
    assert(zipAdd(List(1, 2), List(4, 5, 6)) === List(5, 7))
    assert(zipAdd(List(1, 2, 3), List(4, 5)) === List(5, 7))
  }
}
