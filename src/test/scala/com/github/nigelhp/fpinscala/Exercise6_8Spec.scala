package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_8.nonNegativeLessThan
import fpinscala.state.SimpleRNG
import org.scalatest.FlatSpec

class Exercise6_8Spec extends FlatSpec {
  "nonNegativeLessThan" should "generate a random int n that is: 0 <= n < max" in {
    val Max = 42
    val rng = SimpleRNG(42L)

    val (n, _) = nonNegativeLessThan(Max)(rng)

    assert(n >= 0, ">= 0")
    assert(n < Max, "< Max")
  }
}
