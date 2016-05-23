package com.github.nigelhp.fpinscala

import fpinscala.datastructures._

import Exercise3_7.foldRight

/*
 * Exercise 3.15
 * Write a function that concatenates a list of lists into a single list.  Its runtime should be linear in the total
 * length of all lists.
 * Try to use functions we have already defined.
 */
object Exercise3_15 {

  def concatenate[A](lists: List[List[A]]): List[A] = {
    foldRight(lists, Nil: List[A])((l, acc) => foldRight(l, acc)(Cons(_, _)))
  }
}
