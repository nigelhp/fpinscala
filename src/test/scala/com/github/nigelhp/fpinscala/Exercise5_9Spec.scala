package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_2.take
import com.github.nigelhp.fpinscala.Exercise5_9.from
import org.scalatest.FlatSpec

class Exercise5_9Spec extends FlatSpec {
  "from" should "generate an infinite stream of integers incrementing from the specified value" in {
    assert(toList(take(from(42), 5)) === List(42, 43, 44, 45, 46))
  }
}
