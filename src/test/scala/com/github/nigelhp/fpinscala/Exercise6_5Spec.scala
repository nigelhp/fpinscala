package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_5.{double, nonNegativeInt}
import fpinscala.state.SimpleRNG
import org.scalatest.FlatSpec

class Exercise6_5Spec extends FlatSpec {
  private trait Fixture {
    val rng = SimpleRNG(42)
  }

  "nonNegativeInt" should "return an integer between 0 and Int.MaxValue inclusive" in new Fixture {
    val (n, _) = nonNegativeInt(rng)

    assert((n >= 0) && (n <= Int.MaxValue))
  }

  "double" should "return a random value between 0 and 1 (excluding 1)" in new Fixture {
    val (d, _) = double(rng)

    assert(d >= 0 && d < 1.0D)
  }
}
