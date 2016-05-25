package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import exercise4_1.{Option, Some, None}
import Exercise4_3.map2

class Exercise4_3Spec extends FlatSpec {

  private def f(a: Int, b: Int): String = (a + b).toString

  "map2" should "return None if the first Option argument is None" in {
    assert(map2(None: Option[Int], Some(42))(f) === None)
  }

  it should "return None if the second Option argument is None" in {
    assert(map2(Some(42), None: Option[Int])(f) === None)
  }

  it should "return the result of the mapping function when both arguments are Some" in {
    assert(map2(Some(42), Some(7))(f) === Some("49"))
  }
}
