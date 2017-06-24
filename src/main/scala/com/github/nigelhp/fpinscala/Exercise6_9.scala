package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_8.flatMap
import fpinscala.state.RNG.{Rand, unit}

/*
 * Exercise 6.9
 * Re-implement map and map2 in terms of flatMap.
 * The fact that this is possible is what we're referring to when we say that flatMap is more powerful than
 * map and map2.
 */
object Exercise6_9 {
  def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
    flatMap(s) { a =>
      unit(f(a))
    }

  def map2[A, B, C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    flatMap(ra) { a =>
      map(rb) { b =>
        f(a, b)}
    }
}
