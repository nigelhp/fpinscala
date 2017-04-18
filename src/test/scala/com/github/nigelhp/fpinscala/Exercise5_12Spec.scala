package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_12.{constant, fibs, from, ones}
import com.github.nigelhp.fpinscala.Exercise5_2.take
import org.scalatest.FlatSpec

class Exercise5_12Spec extends FlatSpec {
  "fibs" should "return an infinite stream of Fibonacci numbers" in {
    assert(toList(take(fibs, 12)) === List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
  }

  "from" should "generate an infinite stream of integers incrementing from the specified value" in {
    assert(toList(take(from(42), 5)) === List(42, 43, 44, 45, 46))
  }

  "constant" should "return an infinite stream of the specified value" in {
    assert(toList(take(constant(7), 5)) === List(7, 7, 7, 7, 7))
  }

  "ones" should "return an infinite stream of the value 1" in {
    assert(toList(take(ones, 5)) === List(1, 1, 1, 1, 1))
  }
}
