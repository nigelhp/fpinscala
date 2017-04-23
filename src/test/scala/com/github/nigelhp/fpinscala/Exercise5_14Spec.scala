package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_14.startsWith
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_14Spec extends FlatSpec {
  "startsWith" should "return true when the second stream is a prefix of the first" in {
    assert(startsWith(Stream(1, 2, 3), Stream(1, 2)))
  }

  it should "return false when the second stream is not a prefix of the first" in {
    assert(!startsWith(Stream(1, 2, 3), Stream(1, 3)))
  }

  it should "return true when the second stream is empty" in {
    assert(startsWith(Stream(1, 2, 3), Stream.empty))
  }

  it should "return false when the first stream is empty but the second is not" in {
    assert(!startsWith(Stream.empty, Stream(1, 2)))
  }

  it should "return true when both streams are empty" in {
    assert(startsWith(Stream.empty, Stream.empty))
  }
}
