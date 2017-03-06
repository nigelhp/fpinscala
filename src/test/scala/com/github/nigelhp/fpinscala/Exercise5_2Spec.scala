package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_2.{drop, take}
import fpinscala.laziness.Stream
import org.scalatest.FlatSpec

class Exercise5_2Spec extends FlatSpec {
  "take" should "return an empty stream from an empty stream" in {
    assert(toList(take(Stream.empty, 1)) === Nil)
  }

  it should "return n elements when the stream contains at least n elements" in {
    assert(toList(take(Stream(1,2,3,4), 3)) === List(1,2,3))
  }

  it should "return as many elements as possible when the stream contains less than n elements" in {
    assert(toList(take(Stream(1,2,3), 6)) === List(1,2,3))
  }

  it should "return an empty stream when n is zero" in {
    assert(toList(take(Stream(1,2,3), 0)) === Nil)
  }

  "drop" should "return an empty stream from an empty stream" in {
    assert(toList(drop(Stream.empty, 1)) === Nil)
  }

  it should "return the remaining elements when the stream contains at least n elements" in {
    assert(toList(drop(Stream(1,2,3,4,5), 3)) === List(4,5))
  }

  it should "return an empty stream when the stream contains n elements" in {
    assert(toList(drop(Stream(1,2,3), 3)) === Nil)
  }

  it should "return an empty stream when the stream contains less than n elements" in {
    assert(toList(drop(Stream(1,2,3), 6)) === Nil)
  }

  it should "return the original stream when n is empty" in {
    assert(toList(drop(Stream(1,2,3), 0)) === List(1,2,3))
  }
}
