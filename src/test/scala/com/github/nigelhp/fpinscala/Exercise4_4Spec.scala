package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import exercise4_1.{Option, Some, None}
import Exercise4_4._

class Exercise4_4Spec extends FlatSpec {

  "sequence1" should "return Some(Nil) when the input list is Nil" in {
    assert(sequence1(Nil) === Some(Nil))
  }

  it should "return Some(List(x)) when the input list is List(Some(x))" in {
    assert(sequence1(List(Some(42))) === Some(List(42)))
  }

  it should "return None when the input list is List(None)" in {
    assert(sequence1(List(None)) === None)
  }

  it should "return Some(List(x, y)) when the input list is List(Some(x), Some(y))" in {
    assert(sequence1(List(Some(42), Some(666))) === Some(List(42, 666)))
  }

  it should "return None when the input list is List(Some(x), None, Some(y))" in {
    assert(sequence1(List(Some(42), None, Some(666))) === None)
  }

  "sequence2" should "return Some(Nil) when the input list is Nil" in {
    assert(sequence2(Nil) === Some(Nil))
  }

  it should "return Some(List(x)) when the input list is List(Some(x))" in {
    assert(sequence2(List(Some(42))) === Some(List(42)))
  }

  it should "return None when the input list is List(None)" in {
    assert(sequence2(List(None)) === None)
  }

  it should "return Some(List(x, y)) when the input list is List(Some(x), Some(y))" in {
    assert(sequence2(List(Some(42), Some(666))) === Some(List(42, 666)))
  }

  it should "return None when the input list is List(Some(x), None, Some(y))" in {
    assert(sequence2(List(Some(42), None, Some(666))) === None)
  }
}
