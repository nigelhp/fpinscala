package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_23.zipWith

class Exercise3_23Spec extends FlatSpec {

  "zipWith" should "return an empty list when both input lists are empty" in {
    assert(zipWith(Nil, Nil)((_, _) => 42) === Nil)
  }

  it should "return an empty list when the first input list is empty" in {
    assert(zipWith(Nil: List[Int], List(1, 2, 3))(_ + _) === Nil)
  }

  it should "return an empty list when the second input list is empty" in {
    assert(zipWith(List(1, 2, 3), Nil: List[Int])(_ + _) === Nil)
  }

  it should "return a list containing the result of applying the combining function to the head of both input lists " +
    "when both lists contain a single element" in {
    assert(zipWith(List(1), List(2))(_ + _) === List(3))
  }

  it should "return a list containing the result of applying the combining function to each corresponding pair of " +
    "elements when both lists have the same length" in {
    assert(zipWith(List(1, 2, 3), List(4, 5, 6))(_ + _) === List(5, 7, 9))
  }

  it should "return a list containing the result of applying the combining function to each corresponding pair of " +
    "elements having a length matching that of the shortest input list" in {
    assert(zipWith(List(1, 2), List(4, 5, 6))(_ + _) === List(5, 7))
    assert(zipWith(List(1, 2, 3), List(4, 5))(_ + _) === List(5, 7))
  }
}
