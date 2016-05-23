package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import Exercise2_5.compose

class Exercise2_5Spec extends FlatSpec {

  "compose" should "compose two functions" in {
    val f = compose((b: Int) => b.toString, (a: Int) => a * 10)

    assert(f(1) === "10")
    assert(f(2) === "20")
  }
}
