package com.github.nigelhp.fpinscala

/*
 * Exercise 2.4
 * Implement uncurry, which reverses the transformation of curry.
 * Note that since => associates to the right, A => (B => C) can be written as A => B => C.
 *
 * def uncurry[A,B,C](f: A => B => C): (A, B) => C
 */
object Exercise2_4 {
  def uncurry[A,B,C](f: A => (B => C)): (A, B) => C =
    (a, b) => f(a)(b)
}
