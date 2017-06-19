package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_2.double
import fpinscala.state._
import org.scalatest.FlatSpec

class Exercise6_2Spec extends FlatSpec {
  "double" should "return a random value between 0 and 1 (excluding 1)" in {
    val rng = SimpleRNG(42)
    val (d, _) = double(rng)

    assert(d >= 0 && d < 1.0D)
  }
}
