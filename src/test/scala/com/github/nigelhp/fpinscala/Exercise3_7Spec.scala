package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import fpinscala.datastructures._

import Exercise3_7.{foldLeft, foldRight}

class Exercise3_7Spec extends FlatSpec {

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
}

// substitution model: foldLeft
//  foldLeft(Nil, 1)(_ - _)
//  -> 1
//
//  foldLeft(List(2), 1)(_ - _)
//  foldLeft(Nil, (1 - 2))(_ - _)
//  foldLeft(Nil, -1)(_ - _)
//  -> -1
//
//  foldLeft(List(2, 3), 1)(_ - _)
//  foldLeft(List(3), (1 - 2))(_ - _)
//  foldLeft(List(3), -1)(_ - _)
//  foldLeft(Nil, (-1 - 3))(_ - _)
//  foldLeft(Nil, -4)(_ - _)
//  -> -4
//
//  foldLeft(List(2, 3, 4), 1)(_ - _)
//  foldLeft(List(3, 4), (1 - 2))(_ - _)
//  foldLeft(List(3, 4), -1)(_ - _)
//  foldLeft(List(4), (-1 - 3))(_ - _)
//  foldLeft(List(4), -4)(_ - _)
//  foldLeft(Nil, (-4 - 4))(_ - _)
//  foldLeft(Nil, -8)(_ - _)
//  -> -8

// substitution model: foldRight
//  foldRight(Nil, 1)(_ - _)
//  -> 1
//
//  foldRight(List(2), 1)(_ - _)
//  (2 - foldRight(Nil, 1)(_ - _))
//  (2 - 1)
//  -> 1
//
//  foldRight(List(2, 3), 1)(_ - _)
//  (2 - foldRight(List(3), 1)(_ - _))
//  (2 - (3 - foldRight(Nil, 1)(_ - _)))
//  (2 - (3 - 1))
//  (2 - 2)
//  -> 0
//
//  foldRight(List(2, 3, 4), 1)(_ - _)
//  (2 - foldRight(List(3, 4), 1)(_ - _))
//  (2 - (3 - foldRight(List(4), 1)(_ - _)))
//  (2 - (3 - (4 - foldRight(Nil, 1)(_ - _))))
//  (2 - (3 - (4 - 1)))
//  (2 - (3 - 3))
//  (2 - 0)
//  -> 2
