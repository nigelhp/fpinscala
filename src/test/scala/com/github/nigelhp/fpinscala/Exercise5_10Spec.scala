package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_10.fibs
import com.github.nigelhp.fpinscala.Exercise5_2.take
import org.scalatest.FlatSpec

class Exercise5_10Spec extends FlatSpec {
  "fibs" should "return an infinite stream of Fibonacci numbers" in {
     assert(toList(take(fibs, 12)) === List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
  }
}
