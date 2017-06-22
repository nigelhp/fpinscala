package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_6.map2
import fpinscala.state.RNG
import fpinscala.state.RNG.{Rand, map, unit}

/*
 * Exercise 6.7
 * If you can combine two RNG transitions, you should be able to combine a whole list of them.
 * Implement sequence for combining a list of transitions into a single transition.
 * Use it to re-implement the ints function you wrote before.  For the later, you can use the
 * standard library function List.fill(n)(x) to make a list with x repeated n times.
 *   def sequence[A](fs: List[Rand[A]]): Rand[List[A]]
 */
object Exercise6_7 {
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
    reverse(fs.foldLeft(unit(List.empty[A])) { (acc, f) =>
      map2(acc, f)((ns, n) => n :: ns)
    })

  private def reverse[A](randAs: Rand[List[A]]): Rand[List[A]] =
    map(randAs)(_.reverse)

  def ints(count: Int): Rand[List[Int]] =
    sequence(List.fill(count)(RNG.int))
}
