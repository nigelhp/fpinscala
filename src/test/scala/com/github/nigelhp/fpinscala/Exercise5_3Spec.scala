package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_3.takeWhile
import org.scalatest.FlatSpec
import fpinscala.laziness._

class Exercise5_3Spec extends FlatSpec {

  "takeWhile" should "return an empty stream when the input stream is empty" in {
    assert(toList(takeWhile(Stream.empty)(_ => true)) === Nil)
  }

  it should "return the entire stream when all elements satisfy the predicate" in {
    assert(toList(takeWhile(Stream(1, 2, 3))(_ => true)) === List(1, 2, 3))
  }

  it should "return an empty stream when the first element does not satisfy the predicate" in {
    assert(toList(takeWhile(Stream(0, 1, 2))(_ > 0)) === Nil)
  }

  it should "return all elements prior to the first that does not satisfy the predicate" in {
    assert(toList(takeWhile(Stream(1, 2, -3, 2))(_ > 0)) === List(1, 2))
  }
}
