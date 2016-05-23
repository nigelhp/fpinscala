package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

import Exercise3_7.foldRight

/*
 * Exercise 3.16
 * Write a function that transforms a list of integers by adding 1 to each element.
 * (Reminder: this should be a pure function that returns a new List!)
 */
object Exercise3_16 {

  def increment(list: List[Int]): List[Int] = {
    foldRight(list, Nil: List[Int])((i, acc) => Cons(i + 1, acc))
  }
}
