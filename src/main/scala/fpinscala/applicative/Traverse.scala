package fpinscala.applicative

import scala.language.higherKinds

trait Traverse[F[_]] {
  def traverse[G[_]:Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]

  def sequence[G[_]:Applicative, A](fga: F[G[A]]): G[F[A]] =
    traverse(fga)(identity)
}
