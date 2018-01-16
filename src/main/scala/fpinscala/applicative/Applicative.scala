package fpinscala.applicative

import fpinscala.monads.Functor

import scala.language.higherKinds

trait Applicative[F[_]] extends Functor[F] {
  def unit[A](a: => A): F[A]
  def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C]

  override def map[A, B](fa: F[A])(f: A => B): F[B] =
    map2(fa, unit(())) { (a, _) =>
      f(a)
    }

  def traverse[A, B](as: List[A])(f: A => F[B]): F[List[B]] =
    as.foldRight(unit(List.empty[B])) { (a, fbs) =>
      map2(f(a), fbs)(_ :: _)
    }
}
