package com.github.nigelhp.fpinscala

import fpinscala.parallelism.Par.{Par, lazyUnit}


/*
 * Exercise 7.4
 * This API already establishes a rich set of operations.  Here's a simple example:
 * using lazyUnit, write a function to convert any function A => B to one that evaluates
 * its results asynchronously.
 *   def asyncF[A,B](f: A => B): A => Par[B]
 */
object Exercise7_4 {
  def asyncF[A,B](f: A => B): A => Par[B] =
    (a: A) => lazyUnit(f(a))
}
