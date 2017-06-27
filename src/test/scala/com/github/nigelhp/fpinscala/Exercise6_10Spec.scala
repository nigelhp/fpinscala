package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_10.State
import com.github.nigelhp.fpinscala.Exercise6_10.State.{sequence, unit}
import fpinscala.state.{RNG, SimpleRNG}
import org.scalatest.FlatSpec

class Exercise6_10Spec extends FlatSpec {
  "unit" should "return the specified unit value along with the supplied state" in {
    val Value = 123
    val rng = SimpleRNG(-1L)

    val (a, s) = unit[RNG, Int](Value).run(rng)

    assert(a === Value, "value")
    assert(s === rng, "state")
  }

  "map" should "apply a function of one argument" in {
    val int = State[RNG, Int](_.nextInt)
    val nonNegativeInt = int.map(n => if (n < 0) -(n + 1) else n)
    val rng = SimpleRNG(-1L)

    assert(int.run(rng)._1 < 0, "int")
    assert(nonNegativeInt.run(rng)._1 >= 0, "nonNegativeInt")
  }

  "map2" should "apply a function of two arguments" in {
    val int = State[RNG, Int](_.nextInt)
    val nonNegativeInt = int.map(n => if (n < 0) -(n + 1) else n)
    val rng = SimpleRNG(-1L)

    val (pair, _) = int.map2(nonNegativeInt)((_, _)).run(rng)

    assert(pair._1 < 0, "int")
    assert(pair._2 >= 0, "nonNegativeInt")
  }

  "flatMap" should "return the state returned by the mapping function" in {
    val int = State[RNG, Int](_.nextInt)
    val rng = SimpleRNG(-1L)

    val (nonNegativeInt, _) = int.flatMap(n => unit(if (n < 0) -(n + 1) else n)).run(rng)

    assert(nonNegativeInt >= 0)
  }

  "sequence" should "" in {
    val int = State[RNG, Int](_.nextInt)
    val nonNegativeInt = int.map(n => if (n < 0) -(n + 1) else n)
    val rng = SimpleRNG(-1L)

    val (ints, _) = sequence(List(int, nonNegativeInt)).run(rng)

    assert(ints(0) < 0, "int")
    assert(ints(1) >= 0, "nonNegativeInt")
  }
}
