package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_7.{ints, sequence}
import fpinscala.state.RNG.int
import fpinscala.state.SimpleRNG
import org.scalatest.FlatSpec

class Exercise6_7Spec extends FlatSpec {
  "sequence" should "return an empty list when the input sequence of rands is empty" in {
    val rng = SimpleRNG(42)

    val (seq, _) = sequence(List.empty)(rng)

    assert(seq.isEmpty)
  }

  it should "return a single element list when the input sequence contains a single rand" in {
    val rng = SimpleRNG(42)

    val (seq, _) = sequence(List(int))(rng)

    assert(seq.size === 1)
    assert(seq.head >= Integer.MIN_VALUE && seq.head <= Integer.MAX_VALUE)
  }

  it should "return a triple element list when the input sequence contains three rands" in {
    val rng = SimpleRNG(42)

    val (seq, _) = sequence(List(int, int, int))(rng)

    assert(seq.size === 3)
    seq.foreach(n =>
      assert(n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE)
    )
  }

  it should "return elements in a predictable order" in {
    val rng = SimpleRNG(42)
    val (n1, r1) = int(rng)
    val (n2, _) = int(r1)
    val expected = List(n1, n2)

    val (seq, _) = sequence(List(int, int))(rng)

    assert(seq === expected)
  }

  "ints" should "return a sequence of random ints" in {
    val rng = SimpleRNG(42)
    val (seq, _) = ints(2)(rng)

    assert(seq.size === 2)
    seq.foreach(n =>
      assert(n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE)
    )
  }
}
