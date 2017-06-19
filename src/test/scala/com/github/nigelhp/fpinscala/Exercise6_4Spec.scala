package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_4.ints
import fpinscala.state._
import org.scalatest.FlatSpec

class Exercise6_4Spec extends FlatSpec {
  private val rng = SimpleRNG(42)

  "ints" should "return an empty list when count is zero" in {
    val (values, _) = ints(0)(rng)

    assert(values.isEmpty)
  }

  it should "return a single random int when count is one" in {
    val (values, _) = ints(1)(rng)

    assert(values.size === 1)
    assert(values.head >= Int.MinValue)
    assert(values.head <= Int.MaxValue)
  }

  it should "return multiple random ints when count exceeds one" in {
    val (values, _) = ints(3)(rng)

    assert(values.size === 3)
    values.foreach { i =>
      assert(i >= Int.MinValue)
      assert(i <= Int.MaxValue)
    }
  }
}
