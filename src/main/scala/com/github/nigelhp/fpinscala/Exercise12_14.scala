package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise12_14.{Id, idApplicative}
import fpinscala.applicative.{Applicative, Traverse}

import scala.language.higherKinds

/*
 * Exercise 12.14
 * Implement map in terms of traverse as a method on Traverse[F].
 * This establishes that Traverse is an extension of Functor and that the traverse function is a generalization of map.
 */
trait Exercise12_14[F[_]] extends Traverse[F] {
  def map[A, B](fa: F[A])(f: A => B): F[B] = {
    val g = (a: A) => idApplicative.unit(f(a))
    traverse[Id, A, B](fa)(g)(idApplicative).value
  }
}

private object Exercise12_14 {
  case class Id[A](value: A)

  val idApplicative = new Applicative[Id] {
    override def unit[A](a: => A): Id[A] = Id(a)

    override def map2[A, B, C](fa: Id[A], fb: Id[B])(f: (A, B) => C): Id[C] =
      unit(f(fa.value, fb.value))
  }
}