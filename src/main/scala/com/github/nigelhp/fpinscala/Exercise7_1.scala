package com.github.nigelhp.fpinscala

/*
 * Exercise 7.1
 * Par.map2 is a new higher -order function for combining the result of two parallel
 * computations.  What is its signature?  Give the most general signature possible
 * (don't assume it works only for Int).
 */
object Exercise7_1 {
  trait Par[+A]

  object Par {
    def map2[A,B,C](a: Par[A], b: Par[B])(f: (A, B) => C): Par[C] = ???
  }
}
