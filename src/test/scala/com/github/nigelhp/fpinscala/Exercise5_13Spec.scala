package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_1.toList
import com.github.nigelhp.fpinscala.Exercise5_13._
import fpinscala.laziness.Stream.empty
import fpinscala.laziness._
import org.scalatest.FlatSpec

class Exercise5_13Spec extends FlatSpec {
  "map" should "return an empty stream when the input stream is empty" in {
    assert(toList(map[Int, String](empty)(_.toString)) === Nil)
  }

  it should "apply the supplied mapping function to each input element in turn" in {
    assert(toList(map[Int, String](Stream(1, 2, 3))(_.toString)) === List("1", "2", "3"))
  }

  "take" should "return an empty stream from an empty stream" in {
    assert(toList(take(empty, 1)) === Nil)
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

  "takeWhile" should "return an empty stream when the input stream is empty" in {
    assert(toList(takeWhile(empty)(_ => true)) === Nil)
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

  "zipWith" should "return an empty stream when both input streams are empty" in {
    assert(toList(zipWith(empty, empty)((_, _) => 42)) === Nil)
  }

  it should "return an empty stream when the first input stream is empty" in {
    assert(toList(zipWith(empty[Int], Stream(1, 2, 3))(_ + _)) === Nil)
  }

  it should "return an empty stream when the second input stream is empty" in {
    assert(toList(zipWith(Stream(1, 2, 3), empty[Int])(_ + _)) === Nil)
  }

  it should "return a stream containing the result of applying the combining function to the head of both streams " +
    "when both streams contain a single element" in {
    assert(toList(zipWith(Stream(1), Stream(2))(_ + _)) === List(3))
  }

  it should "return a stream containing the result of applying the combining function to each corresponding pair of " +
    "elements when both streams have the same length" in {
    assert(toList(zipWith(Stream(1, 2, 3), Stream(4, 5, 6))(_ + _)) === List(5, 7, 9))
  }

  it should "return a stream containing the result of applying the combining function to each corresponding pair of " +
    "elements having a length matching that of the shortest stream" in {
    assert(toList(zipWith(Stream(1, 2), Stream(4, 5, 6))(_ + _)) === List(5, 7))
    assert(toList(zipWith(Stream(1, 2, 3), Stream(4, 5))(_ + _)) === List(5, 7))
  }

  "zipAll" should "return an empty stream when both input streams are empty" in {
    assert(toList(zipAll(empty, empty)) === Nil)
  }

  it should "return None values in place of the first stream when it is empty" in {
    assert(toList(zipAll(empty[Int], Stream(1, 2, 3))) === List((None, Some(1)), (None, Some(2)), (None, Some(3))))
  }

  it should "return None values in place of the second stream when it is empty" in {
    assert(toList(zipAll(Stream(1, 2, 3), empty[Int])) === List((Some(1), None), (Some(2), None), (Some(3), None)))
  }

  it should "return a stream containing the head of both streams when both streams contain a single element" in {
    assert(toList(zipAll(Stream(1), Stream(2))) === List((Some(1), Some(2))))
  }

  it should "return a stream containing all the pairs of values when both streams have the same length" in {
    assert(toList(zipAll(Stream(1, 2, 3), Stream(4, 5, 6))) === List(
      (Some(1), Some(4)), (Some(2), Some(5)), (Some(3), Some(6))))
  }

  it should "return a stream substituting None values when one stream is shorter than the other" in {
    assert(toList(zipAll(Stream(1, 2), Stream(4, 5, 6))) === List(
      (Some(1), Some(4)), (Some(2), Some(5)), (None, Some(6))))
    assert(toList(zipAll(Stream(1, 2, 3), Stream(4, 5))) === List(
      (Some(1), Some(4)), (Some(2), Some(5)), (Some(3), None)))
  }
}
