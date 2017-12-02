package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_9.{isOrdered, isOrderedAscending}
import org.scalatest.FlatSpec

class Exercise10_9Spec extends FlatSpec {
  "An IndexedSeq" should "be ordered ascending when empty" in {
    assert(isOrderedAscending(IndexedSeq.empty[Int]))
  }

  it should "be ordered ascending when it contains a single element" in {
    assert(isOrderedAscending(IndexedSeq(42)))
  }

  it should "be ordered ascending when it contains two elements having the same value" in {
    assert(isOrderedAscending(IndexedSeq(1, 1)))
  }

  it should "be ordered ascending when it contains two elements in ascending order" in {
    assert(isOrderedAscending(IndexedSeq(1, 2)))
  }

  it should "not be ordered ascending when it contains two elements in descending order" in {
    assert(!isOrderedAscending(IndexedSeq(2, 1)))
  }

  it should "be ordered when empty" in {
    assert(isOrdered(IndexedSeq.empty[Int]))
  }

  it should "be ordered when it contains a single element" in {
    assert(isOrdered(IndexedSeq(42)))
  }

  it should "be ordered when it consists of multiple elements having the same value" in {
    assert(isOrdered(IndexedSeq(1, 1, 1)))
  }

  it should "be ordered when it contains elements in ascending order" in {
    assert(isOrdered(IndexedSeq(1, 2, 3)))
  }

  it should "be ordered when it contains duplicated elements in ascending order" in {
    assert(isOrdered(IndexedSeq(1, 1, 2, 2, 3, 3)))
  }

  it should "be ordered when it contains elements in descending order" in {
    assert(isOrdered(IndexedSeq(3, 2, 1)))
  }

  it should "be ordered when it contains duplicated elements in descending order" in {
    assert(isOrdered(IndexedSeq(3, 3, 2, 2, 1, 1)))
  }

  it should "not be ordered when an otherwise ascending sequence starts with too high a value" in {
    assert(!isOrdered(IndexedSeq(3, 1, 2)))
  }

  it should "not be ordered when an otherwise ascending sequence ends with too low a value" in {
    assert(!isOrdered(IndexedSeq(1, 2, 1)))
  }

  it should "not be ordered when an otherwise descending sequence starts with too low a value" in {
    assert(!isOrdered(IndexedSeq(1, 2, 1)))
  }

  it should "not be ordered when an otherwise descending sequence ends with too high a value" in {
    assert(!isOrdered(IndexedSeq(3, 2, 3)))
  }
}