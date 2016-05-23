package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_17.asStrings

class Exercise3_17Spec extends FlatSpec {

  "asStrings" should "return an empty list when the input list is empty" in {
    assert(asStrings(Nil) === Nil)
  }

  it should "return a list containing a single string when the input list contains a single double" in {
    assert(asStrings(List(3.1419)) === List("3.1419"))
  }

  it should "return a list containing the string representations of all the doubles in the input list" in {
    assert(asStrings(List(3.1419, 2.71828, 42.0)) === List("3.1419", "2.71828", "42.0"))
  }
}
