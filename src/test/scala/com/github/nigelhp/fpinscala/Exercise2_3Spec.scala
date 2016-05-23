package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import Exercise2_3.{partial1, curry}

class Exercise2_3Spec extends FlatSpec {

  "partial application" should "return a new function that requires fewer arguments" in {
    val fn = partial1(10, (x: Int, y: Int) => x + y)

    assert(fn(1) === 11)
    assert(fn(2) === 12)
  }

  "currying" should "return a new function that partially applies its argument" in {
    val fn = curry((x: Int, y: Int) => x + y)
    val f = fn(10)

    assert(f(1) === 11)
    assert(f(2) === 12)
  }
}
