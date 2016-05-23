package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

import Exercise3_7.foldRight
import Exercise3_14.append

/*
 * Exercise 3.20
 * Write a function flatMap that works like map except that the function given will return a list instead of a
 * single result, and that list should be inserted into the final resulting list.  Here is its signature
 *
 * def flatMap[A, B](as: List[A])(f: A => List[B]): List[B]
 *
 * For instance, flatMap(List(1, 2, 3))(i => List(i, i)) should result in List(1, 1, 2, 2, 3, 3).
 */
object Exercise3_20 {

  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {
    foldRight(as, Nil: List[B])((a, acc) => append(f(a), acc))
  }
}
