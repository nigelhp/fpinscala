package com.github.nigelhp.fpinscala

import org.scalatest.FlatSpec

/*
 * Note that this chapter is focused on Monoids - where the binary operation must be associative.
 * The implementation of foldLeft and foldRight are here tested with a non-associate operation however.  For an
 * associative operation the results should be the same, and it would be all too easy for one of the implementations
 * to pass the tests without applying the operation to the elements in the correct order.
 */
class Exercise10_6Spec extends FlatSpec {

  private val values = List(3, 2, 1)
  private val initialValue = 10
  private val subtract: (Int, Int) => Int = _ - _
  private val add: (Int, Int) => Int = _ + _

  "foldLeft via foldMap" should "fold correctly from left to right (when the operation is non-associative)" in {
    val expectedResult = 4

    assert(Exercise10_6.foldLeft(values, initialValue)(subtract) == expectedResult &&
      values.foldLeft(initialValue)(subtract) == expectedResult)
  }

  "foldLeft via foldMap" should "fold correctly from left to right (when the operation is associative)" in {
    val expectedResult = 16

    assert(Exercise10_6.foldLeft(values, initialValue)(add) == expectedResult &&
      values.foldLeft(initialValue)(add) == expectedResult)
  }

  "foldRight via foldMap" should "fold correctly from right to left (when the operation is non-associative)" in {
    val expectedResult = -8

    assert(Exercise10_6.foldRight(values, initialValue)(subtract) == expectedResult &&
      values.foldRight(initialValue)(subtract) == expectedResult)
  }

  "foldRight via foldMap" should "fold correctly from right to left (when the operation is associative)" in {
    val expectedResult = 16

    assert(Exercise10_6.foldRight(values, initialValue)(add) == expectedResult &&
      values.foldRight(initialValue)(add) == expectedResult)
  }
}