package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_13.map
import com.github.nigelhp.fpinscala.Exercise5_15.tails
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_15Spec extends FlatSpec {
  "tails" should "return a stream of tails when the input stream is not empty" in {
    val ts = tails(Stream(1, 2, 3))

    assert(toLists(ts) === List(List(1, 2, 3), List(2, 3), List(3), Nil))
  }

  it should "return a stream consisting of the empty stream when the input stream is empty" in {
    assert(toLists(tails(Stream.empty)) === List(Nil))
  }

  private def toLists[A](s: Stream[Stream[A]]): List[List[A]] =
    toList(map(s)(toList))
}
