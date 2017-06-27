package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_10.State.unit

/*
 * Exercise 6.10
 * Generalize the functions unit, map, map2, flatMap and sequence.
 * Add them as methods on the State case class where possible.
 * Otherwise you should put them in a State companion object.
 */
object Exercise6_10 {
  case class State[S, +A](run: S => (A, S)) {
    def flatMap[B](f: A => State[S, B]): State[S, B] =
      State(s => {
        val (a, nextS) = run(s)
        f(a).run(nextS)
      })

    def map[B](f: A => B): State[S, B] =
      flatMap { a =>
        unit(f(a))
      }

    def map2[B, C](sb: State[S, B])(f: (A, B) => C): State[S, C] =
      flatMap { a =>
        sb.map(b => f(a, b))
      }
  }

  object State {
    def unit[S, A](a: A): State[S, A] =
      State(s => (a, s))

    def sequence[S, A](states: List[State[S, A]]): State[S, List[A]] =
      reverse(states.foldLeft(unit[S, List[A]](List.empty[A])) { (acc, s) =>
        acc.map2(s) { (as, a) => a :: as}
      })

    private def reverse[S, A](as: State[S, List[A]]): State[S, List[A]] =
      as.map(_.reverse)
  }
}
