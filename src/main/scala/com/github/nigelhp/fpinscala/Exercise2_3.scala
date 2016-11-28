package com.github.nigelhp.fpinscala

/*
 * Exercise 2.3
 * Let's look at another example, currying, which converts a function f of two arguments
 * into a function of one argument that partially applies f.  Here again there's only one
 * implementation that compiles.  Write this implementation:
 *
 * def curry[A,B,C](f: (A, B) => C): A => (B => C)
 */
object Exercise2_3 {

  /*
   * Takes a value and a function of two arguments, and returns a function of one argument.
   */
  def partial1[A,B,C](a: A, f: (A, B) => C): B => C =
    (b: B) => f(a, b)

  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)
}
