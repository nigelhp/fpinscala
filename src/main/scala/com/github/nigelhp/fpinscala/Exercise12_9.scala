package com.github.nigelhp.fpinscala

import fpinscala.applicative.Applicative

import scala.language.{higherKinds, reflectiveCalls}

/*
 * Exercise 12.9
 * Applicative functors also compose another way!
 * If F[_] and G[_] are applicative functors, then so is F[G[_]].
 * Implement this function:
 *   def compose[G[_]](G: Applicative[G]): Applicative[({type f[x] = F[G[x]]})#f]
 */
trait Exercise12_9[F[_]] extends Applicative[F] {
  def compose[G[_]](G: Applicative[G]): Applicative[({type f[x] = F[G[x]]})#f] = new Applicative[({type f[x] = F[G[x]]})#f] {
    override def unit[A](a: => A): F[G[A]] = Exercise12_9.this.unit(G.unit(a))

    override def map2[A, B, C](fga: F[G[A]], fgb: F[G[B]])(f: (A, B) => C): F[G[C]] =
      Exercise12_9.this.map2(fga, fgb) { (ga, gb) =>
        G.map2(ga, gb)(f)
      }
  }
}
