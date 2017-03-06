package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_1Spec extends FlatSpec {
  "toList" should "return an empty list when the stream is empty" in {
    assert(toList(Stream.empty) === List.empty)
  }

  it should "return a single element list when the stream contains a single value" in {
    assert(toList(Stream(42)) === List(42))
  }

  it should "return a multi element list when the stream contains multiple values" in {
    assert(toList(Stream(42, 36, 30)) === List(42, 36, 30))
  }
}
