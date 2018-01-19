package com.github.nigelhp.fpinscala

import fpinscala.applicative.Applicative

import scala.language.{higherKinds, reflectiveCalls}

/*
 * Exercise 12.8
 * Just like we can take the product of two monoids A and B to give the monoid (A, B), we can take the product of two
 * applicative functors.
 * Implement this function:
 *   def product[G[_]](G: Applicative[G]): Applicative[({type f[x] = (F[x], G[x])})#f]
 */
trait Exercise12_8[F[_]] extends Applicative[F] {
  def product[G[_]](G: Applicative[G]): Applicative[({type f[x] = (F[x], G[x])})#f] = new Applicative[({type f[x] = (F[x], G[x])})#f] {
    override def unit[A](a: => A) = (Exercise12_8.this.unit(a), G.unit(a))

    override def map2[A, B, C](pa: (F[A], G[A]), pb: (F[B], G[B]))(f: (A, B) => C): (F[C], G[C]) = {
      val fc = Exercise12_8.this.map2(pa._1, pb._1)(f)
      val gc = G.map2(pa._2, pb._2)(f)
      fc -> gc
    }
  }
}
