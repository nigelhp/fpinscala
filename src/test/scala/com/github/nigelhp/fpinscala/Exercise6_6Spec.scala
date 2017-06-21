package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_5.double
import com.github.nigelhp.fpinscala.Exercise6_6.map2
import fpinscala.state.RNG.int
import fpinscala.state.SimpleRNG
import org.scalatest.FlatSpec

class Exercise6_6Spec extends FlatSpec {
  "map2" should "allow us to implement intDouble" in {
    val rng = SimpleRNG(42)
    val intDouble = map2(int, double)((_, _))

    val (pair, _) = intDouble(rng)

    assert(pair._1 >= Integer.MIN_VALUE && pair._1 <= Integer.MAX_VALUE)
    assert(pair._2 >= 0D && pair._2 < 1D)
  }

  it should "allow us to implement doubleInt" in {
    val rng = SimpleRNG(42)
    val doubleInt = map2(double, int)((_, _))

    val (pair, _) = doubleInt(rng)

    assert(pair._1 >= 0D && pair._1 < 1D)
    assert(pair._2 >= Integer.MIN_VALUE && pair._2 <= Integer.MAX_VALUE)
  }
}
