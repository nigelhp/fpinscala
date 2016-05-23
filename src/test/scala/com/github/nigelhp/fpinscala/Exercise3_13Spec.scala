package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_13.{foldLeft, foldRight, foldRightViaFoldLeft}

class Exercise3_13Spec extends FlatSpec {

  private val nil: List[Int] = Nil

  "foldLeft" should "return the seed value when the input list is empty" in {
    assert(foldLeft(nil, 10)((acc, i) => 666) === 10)
  }

  it should "combine the seed value with the elements of the input list" in {
    assert(foldLeft(List(1), 10)(_ + _) === 11)
  }

  it should "support calculating the sum of all the elements of the input list" in {
    assert(foldLeft(nil, 0)(_ + _) === 0)
    assert(foldLeft(List(1, 2, 3, 4, 5), 0)(_ + _) === 15)
  }

  it should "support calculating the product of all the elements of the input list" in {
    assert(foldLeft(nil, 1)(_ * _) === 1)
    assert(foldLeft(List(1, 2, 3, 4, 5), 1)(_ * _) === 120)
  }

  it should "traverse from left to right" in {
    assert(foldLeft(List(1), 10)(_ - _) === 9)
    assert(foldLeft(List(1, 2, 3, 4, 5), 0)(_ - _) === -15)

    assert(foldLeft(List(2, 3, 4), ("", 1))((acc, i) => {(acc._1 + s"(${acc._2}+$i)", acc._2 + i)}) ===
      ("(1+2)(3+3)(6+4)", 10))
  }

  "foldRight" should "return the seed value when the input list is empty" in {
    assert(foldRight(nil, 10)((i, acc) => 666) === 10)
  }

  it should "combine the seed value with the elements of the input list" in {
    assert(foldRight(List(1), 10)(_ + _) === 11)
  }

  it should "support calculating the sum of all the elements of the input list" in {
    assert(foldRight(nil, 0)(_ + _) === 0)
    assert(foldRight(List(1, 2, 3, 4, 5), 0)(_ + _) === 15)
  }

  it should "support calculating the product of all the elements of the input list" in {
    assert(foldRight(nil, 1)(_ * _) === 1)
    assert(foldRight(List(1, 2, 3, 4, 5), 1)(_ * _) === 120)
  }

  it should "traverse from right to left" in {
    assert(foldRight(List(1), 10)(_ - _) === -9)
    assert(foldRight(List(1, 2, 3, 4, 5), 0)(_ - _) === 3)

    assert(foldRight(List(2, 3, 4), ("", 1))((i, acc) => {(acc._1 + s"($i+${acc._2})", i + acc._2)}) ===
      ("(4+1)(3+5)(2+8)", 10))
  }

  "foldRightViaFoldLeft" should "return the seed value when the input list is empty" in {
    assert(foldRightViaFoldLeft(nil, 10)((i, acc) => 666) === 10)
  }

  it should "combine the seed value with the elements of the input list" in {
    assert(foldRightViaFoldLeft(List(1), 10)(_ + _) === 11)
  }

  it should "support calculating the sum of all the elements of the input list" in {
    assert(foldRightViaFoldLeft(nil, 0)(_ + _) === 0)
    assert(foldRightViaFoldLeft(List(1, 2, 3, 4, 5), 0)(_ + _) === 15)
  }

  it should "support calculating the product of all the elements of the input list" in {
    assert(foldRightViaFoldLeft(nil, 1)(_ * _) === 1)
    assert(foldRightViaFoldLeft(List(1, 2, 3, 4, 5), 1)(_ * _) === 120)
  }

  it should "traverse from right to left" in {
    assert(foldRightViaFoldLeft(List(1), 10)(_ - _) === -9)
    assert(foldRightViaFoldLeft(List(1, 2, 3, 4, 5), 0)(_ - _) === 3)

    assert(foldRightViaFoldLeft(List(2, 3, 4), ("", 1))((i, acc) => {(acc._1 + s"($i+${acc._2})", i + acc._2)}) ===
      ("(4+1)(3+5)(2+8)", 10))
  }

  it should "blah" in {
    assert(foldRightViaFoldLeft(Nil: List[Int], 1)(_ - _) === 1)
  }
}
