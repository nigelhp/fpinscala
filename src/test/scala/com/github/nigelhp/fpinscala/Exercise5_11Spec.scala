package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_11.unfold
import org.scalatest.FlatSpec

class Exercise5_11Spec extends FlatSpec {
  "unfold" should "" in {
    assert(toList(unfold(1)(s => if (s < 11) Some(s * s, s + 1) else None)) ===
      List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100))
  }
}
