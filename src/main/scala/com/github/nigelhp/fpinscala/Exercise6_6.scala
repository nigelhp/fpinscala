package com.github.nigelhp.fpinscala

import fpinscala.state.RNG.Rand

/*
 * Exercise 6.6
 * Write the implementation of map2 based on the following signature.
 * This function takes two actions, ra and rb, and a function f for combining their results,
 * and returns a new action that combines them:
 *   def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C]
 */
object Exercise6_6 {
  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    rng => {
      val (a, rng2) = ra(rng)
      val (b, rng3) = rb(rng2)
      (f(a, b), rng3)
    }
}
