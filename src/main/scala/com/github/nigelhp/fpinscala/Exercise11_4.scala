package com.github.nigelhp.fpinscala


import scala.language.higherKinds

/*
 * Implement replicateM.
 *   def replicateM[A](n: Int, ma: F[A]): F[List[A]]
 */
trait Exercise11_4[F[_]] extends Exercise11_3[F] {
  def replicateM[A](n: Int, ma: F[A]): F[List[A]] =
    sequence(List.fill(n)(ma))
}
