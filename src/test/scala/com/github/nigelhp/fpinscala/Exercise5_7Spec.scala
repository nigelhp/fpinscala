package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_7._
import fpinscala.laziness.Stream.empty
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_7Spec extends FlatSpec {

  "map" should "return an empty stream when the input stream is empty" in {
    assert(toList(map[Int, String](empty)(_.toString)) === Nil)
  }

  it should "apply the supplied mapping function to each input element in turn" in {
    assert(toList(map[Int, String](Stream(1, 2, 3))(_.toString)) === List("1", "2", "3"))
  }

  "filter" should "return an empty stream when the input stream is empty" in {
    assert(toList(filter(empty)(_ => true)) === Nil)
  }

  it should "include only those elements that satisfy the supplied predicate" in {
    assert(toList(filter(Stream(1, 2, 3, 4))(i => i % 2 == 0)) === List(2, 4))
  }

  "append" should "return an empty stream if both streams are empty" in {
    assert(toList(append(empty[Int], empty)) === Nil)
  }

  it should "return the first stream if the second stream is empty" in {
    assert(toList(append(Stream(1, 2, 3), empty)) === List(1, 2, 3))
  }

  it should "return the second stream if the first stream is empty" in {
    assert(toList(append(empty[Int], Stream(4, 5, 6))) === List(4, 5, 6))
  }

  it should "append the elements of the second stream to the first stream" in {
    assert(toList(append(Stream(1, 2, 3), Stream(4, 5, 6))) === List(1, 2, 3, 4, 5, 6))
  }

  "flatMap" should "return an empty stream when the input stream is empty" in {
    assert(toList(flatMap(empty)(_ => Stream(1, 2))) === Nil)
  }

  it should "applied the supplied mapping function to each input element in turn and flatten the results" in {
    assert(toList(flatMap(Stream(2, 3, 4))(i => Stream(i.toString, (i * i).toString))) ===
      List("2", "4", "3", "9", "4", "16"))
  }
}
