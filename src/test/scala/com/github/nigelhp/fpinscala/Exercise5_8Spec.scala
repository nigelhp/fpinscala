package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_2.take
import com.github.nigelhp.fpinscala.Exercise5_8.constant
import org.scalatest.FlatSpec

class Exercise5_8Spec extends FlatSpec {
  "constant" should "return an infinite stream of the specified value" in {
    assert(toList(take(constant(7), 4)) === List(7, 7, 7, 7))
  }
}
