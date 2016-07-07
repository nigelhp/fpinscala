package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

import exercise4_6._
import Exercise4_7._

class Exercise4_7Spec extends FlatSpec {

  "sequence" should "return Right(Nil) when the input list is empty" in {
    assert(sequence(List()) === Right(Nil))
  }

  it should "return the Left when supplied a singleton list containing a Left" in {
    val left = Left("Hello World!")

    assert(sequence(List(left)) === left)
  }

  it should "return the Left when supplied a list containing a Right and a Left" in {
    val left = Left("Hello World!")

    assert(sequence(List(Right(42), left)) === left)
  }

  it should "return the first Left when supplied a list containing multiple Lefts" in {
    val left1 = Left("Hello World!")
    val left2 = Left("Goodbye cruel World!")

    assert(sequence(List(left1, left2)) === left1)
  }

  it should "return Right(List(x)) when supplied List(Right(x))" in {
    assert(sequence(List(Right(42))) === Right(List(42)))
  }

  it should "return Right(List(x, y)) when supplied List(Right(x), Right(y))" in {
    val right1 = Right(42)
    val right2 = Right(666)

    assert(sequence(List(right1, right2)) === Right(List(42, 666)))
  }

  "traverse" should "return Right(Nil) when the input list is empty" in {
    val f: String => Either[Throwable, Int] = s => Right(666)

    assert(traverse(List())(f) === Right(Nil))
  }

  it should "return a Right containing a singleton list when the input list contains a single value that will be transformed into a Right" in {
    val f: String => Either[Throwable, Int] = s => Right(s.toInt + 1)

    assert(traverse(List("1"))(f) === Right(List(2)))
  }

  it should "return a Left when the input list contains a single value that will be transformed into a Left" in {
    val f: String => Either[String, Int] = Left(_)

    assert(traverse(List("1"))(f) === Left("1"))
  }

  it should "return a Right containing a list of all transformed values when the input list contains multiple values, all of which will be transformed into a Right" in {
    val f: String => Either[Throwable, Int] = s => Right(s.toInt + 1)

    assert(traverse(List("10", "20", "30"))(f) === Right(List(11, 21, 31)))
  }

  it should "return a Left when the input list contains multiple values, and the last value will be transformed into a Left" in {
    val f: String => Either[String, Int] = s => {
      val x = s.toInt
      if (x % 2 > 0) Left(s) else Right(x + 1)
    }

    assert(traverse(List("10", "20", "31"))(f) === Left("31"))
  }

  it should "return the first Left when the input list contains multiple values that will be transformed into a Left" in {
    val f: String => Either[String, Int] = s => Left(s)

    assert(traverse(List("10", "20", "30"))(f) === Left("10"))
  }
}
