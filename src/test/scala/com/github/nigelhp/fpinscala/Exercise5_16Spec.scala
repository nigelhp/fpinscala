package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_16.scanRight
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_16Spec extends FlatSpec {
  "scanRight" should "return a stream of the intermediate fold values" in {
    assert(toList(scanRight(Stream(1, 2, 3), 0)(_ + _)) === List(6, 5, 3, 0))
  }

  it should "return the initial value only when the input stream is empty" in {
    assert(toList(scanRight(Stream.empty[Int], 0)(_ + _)) === List(0))
  }

  "tails" should "be implementable via scanRight" in {
    val tails = toList(scanRight(Stream(1, 2, 3), Stream.empty[Int])((a, b) => Stream.cons(a, b)))

    assert(tails.map(toList) === List(List(1, 2, 3), List(2, 3), List(3), Nil))
  }
}
