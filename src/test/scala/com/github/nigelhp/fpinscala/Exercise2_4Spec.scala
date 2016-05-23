package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import Exercise2_3.curry
import Exercise2_4.uncurry

class Exercise2_4Spec extends FlatSpec {

  "uncurry" should "convert a curried function back into a function of two arguments" in {
    val curried = curry((x: Int, y: Int) => x + y)
    val uncurried = uncurry(curried)

    assert(uncurried(10, 1) === 11)
    assert(uncurried(10, 2) === 12)
  }
}
