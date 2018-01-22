package com.github.nigelhp.fpinscala

import fpinscala.applicative.Applicative

import scala.language.higherKinds

/*
 * Exercise 12.12
 * On the Applicative trait, implement sequence over a Map rather than a List:
 *   def sequenceMap[K, V](ofa: Map[K, F[V]]): F[Map[K, V]]
 */
trait Exercise12_12[F[_]] extends Applicative[F] {
  def sequenceMap[K, V](ofa: Map[K, F[V]]): F[Map[K, V]] =
    ofa.foldLeft(unit(Map.empty[K, V])) { case (fmap, (k, fv)) =>
      map2(fmap, fv) { (map, v) =>
        map + (k -> v)
      }
    }
}
