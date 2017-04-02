package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_6.headOption
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_6Spec extends FlatSpec {
  "headOption" should "return None when the stream is empty" in {
    assert(headOption(Stream.empty) === None)
  }

  it should "return the element when the stream contains a single element" in {
    assert(headOption(Stream(42)) === Some(42))
  }

  it should "return the head element when the stream contains multiple elements" in {
    assert(headOption(Stream(1, 2, 3)) === Some(1))
  }
}
