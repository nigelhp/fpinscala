package com.github.nigelhp.fpinscala.exercise4_6

import org.scalatest.FlatSpec

class Exercise4_6Spec extends FlatSpec {

  private val left: Either[Int, String] = Left(42)
  private val right: Either[Int, String] = Right("42")

  "map" should "return the original Either when invoked on a Left" in {
    assert(left.map(_.toString) === left)
  }

  it should "return the result of the mapping function when invoked on a Right" in {
    assert(right.map(_.reverse) === Right("24"))
  }

  "flatMap" should "return the original Either when invoked on a Left" in {
    assert(left.flatMap(n => Right(n.toString)) === left)
  }

  it should "return the result of the mapping function when invoked on a Right" in {
    assert(right.flatMap(s => Left(s.toInt)) === Left(42))
    assert(right.flatMap(s => Right(s.reverse)) === Right("24"))
  }

  "orElse" should "return the supplied alternative when invoked on a Left" in {
    assert(left.orElse(right) === right)
  }

  it should "return the original Either when invoked on a Right" in {
    assert(right.orElse(left) === right)
  }

  "map2" should "return the original Either when invoked on a Left" in {
    assert(left.map2(right)((_, _) => BigDecimal(666)) === left)
  }

  it should "return the supplied Either when it is a Left" in {
    assert(right.map2(left)((_, _) => BigDecimal(666)) === left)
  }

  it should "return the result of the mapping function when invoked on a Right with a Right" in {
    assert(right.map2(Right("7"))((a, b) => BigDecimal(a.toInt + b.toInt)) === Right(BigDecimal(49)))
  }
}
