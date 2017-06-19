package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_3.{double3, doubleInt, intDouble}
import fpinscala.state._
import org.scalatest.FlatSpec

class Exercise6_3Spec extends FlatSpec {
  private val rng = SimpleRNG(42)

  "intDouble" should "return a random int, double pair" in {
    val (pair, _) = intDouble(rng)

    assert(pair._1 >= Integer.MIN_VALUE && pair._1 <= Integer.MAX_VALUE)
    assert(pair._2 >= 0D && pair._2 < 1D)
  }

  "doubleInt" should "return a random double, int pair" in {
    val (pair, _) = doubleInt(rng)

    assert(pair._1 >= 0D && pair._1 < 1D)
    assert(pair._2 >= Integer.MIN_VALUE && pair._2 <= Integer.MAX_VALUE)
  }

  "double3" should "return a random double 3-tuple" in {
    val (triple, _) = double3(rng)

    assert(triple._1 >= 0D && triple._1 < 1D)
    assert(triple._2 >= 0D && triple._2 < 1D)
    assert(triple._3 >= 0D && triple._3 < 1D)
  }
}
