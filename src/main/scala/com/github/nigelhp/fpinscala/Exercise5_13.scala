package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_11.unfold
import fpinscala.laziness.Stream.empty
import fpinscala.laziness._

/*
 * Exercise 5.13
 * Use unfold to implement map, take, takeWhile, zipWith (as in Chapter 3), and zipAll.
 * The zipAll function should continue the traversal as long as either stream has more
 * elements - it uses Option to indicate whether each stream has been exhausted.
 */
object Exercise5_13 {
  def map[A, B](as: Stream[A])(fn: A => B): Stream[B] =
    unfold(as) {
      case Cons(a, s) => Some(fn(a()) -> s())
      case _ => None
    }

  def take[A](as: Stream[A], n: Int): Stream[A] =
    unfold((as, 0)) {
      case (Cons(a, s), index) if index < n => Some(a() -> (s(), index + 1))
      case _ => None
    }

  def takeWhile[A](as: Stream[A])(p: A => Boolean): Stream[A] =
    unfold(as) {
      case Cons(a, s) if p(a()) => Some(a() -> s())
      case _ => None
    }

  def zipWith[A, B, C](as: Stream[A], bs: Stream[B])(fn: (A, B) => C): Stream[C] =
    unfold((as, bs)) {
      case (Cons(a, aas), Cons(b, bbs)) => Some(fn(a(), b()) -> (aas(), bbs()))
      case _ => None
    }

  def zipAll[A, B](as: Stream[A], bs: Stream[B]): Stream[(Option[A], Option[B])] =
    zipWithAll(as, bs)((_, _))

  private def zipWithAll[A, B, C](as: Stream[A], bs: Stream[B])(fn: (Option[A], Option[B]) => C): Stream[C] =
    unfold((as, bs)) {
      case (Cons(a, aas), Cons(b, bbs)) => Some(fn(Some(a()), Some(b())) -> (aas(), bbs()))
      case (Cons(a, aas), Empty) => Some(fn(Some(a()), None) -> (aas(), empty))
      case (Empty, Cons(b, bbs)) => Some(fn(None, Some(b())) -> (empty, bbs()))
      case _ => None
    }
}
