package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise10_3.endoMonoid
import com.github.nigelhp.fpinscala.Exercise10_5.foldMap
import fpinscala.monoids.Monoid

/*
 * Exercise 10.6
 * The foldMap function can be implemented using either foldLeft or foldRight.
 * But you can also write foldLeft and foldRight using foldMap!  Try it.
 */
object Exercise10_6 {
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    val m = new Monoid[B => B] {
      val endoB = endoMonoid[B]
      override def op(a1: B => B, a2: B => B): B => B = endoB.op(a2, a1)  // reverse argument order
      override def zero = endoB.zero
    }

    foldMap(as, m) { a =>
      f(_, a)
    }(z)
  }

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = {
    val m = endoMonoid[B]
    foldMap(as, m) { a =>
      val aToEndoB: A => (B => B) = f.curried
      aToEndoB(a)
    }(z)
  }
}
