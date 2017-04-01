package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_4.forAll
import org.scalatest.FlatSpec
import fpinscala.laziness._

class Exercise5_4Spec extends FlatSpec {

  "forAll" should "return false when the sole element does not satisfy the predicate" in {
    assert(!forAll(Stream(-1))(_ > 0))
  }

  it should "return false when the last element does not satisfy the predicate" in {
    assert(!forAll(Stream(1, 0))(_ > 0))
  }

  it should "return true when the stream is empty" in {
    assert(forAll(Stream.empty)(_ => false))
  }

  it should "return true when the sole element satisfies the predicate" in {
    assert(forAll(Stream(1))(_ > 0))
  }

  it should "return true when all elements satisfy the predicate" in {
    assert(forAll(Stream(1, 2, 3))(_ > 0))
  }
}
