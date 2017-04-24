package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_1.nonNegativeInt
import fpinscala.state._
import org.scalatest.FlatSpec

class Exercise6_1Spec extends FlatSpec {
  private val rng = SimpleRNG(42)

  "nonNegativeInt" should "return an integer between 0 and Int.MaxValue inclusive" in {
    val (n, _) = nonNegativeInt(rng)

    assert((n >= 0) && (n <= Int.MaxValue))
  }

  it should "consistently return the same value from the same random number generator" in {
    val (n1, _) = nonNegativeInt(rng)
    val (n2, _) = nonNegativeInt(rng)

    assert(n1 === n2)
  }

  it should "return a different value from a different random number generator state (excluding wrap-around)" in {
    val (n1, nextRng) = nonNegativeInt(rng)
    val (n2, _) = nonNegativeInt(nextRng)

    assert(n1 != n2)
  }
}
