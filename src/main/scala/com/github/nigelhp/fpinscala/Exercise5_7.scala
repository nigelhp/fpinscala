package com.github.nigelhp.fpinscala

import fpinscala.laziness.Stream.{cons, empty}
import fpinscala.laziness._

/*
 * Exercise 5.7
 * Implement map, filter, append, and flatMap using foldRight.
 * The append method should be non-strict in its argument.
 */
object Exercise5_7 {
  def map[A, B](stream: Stream[A])(fn: A => B): Stream[B] =
    stream.foldRight(empty[B]) { (a, acc) =>
      cons(fn(a), acc)
    }

  def filter[A](stream: Stream[A])(p: A => Boolean): Stream[A] =
    stream.foldRight(empty[A]) { (a, acc) =>
      if (p(a)) cons(a, acc) else acc
    }

  def append[A, B>:A](stream: Stream[A], other: => Stream[B]): Stream[B] =
    stream.foldRight(other) { (a, acc) =>
      cons(a, acc)
    }

  def flatMap[A, B](stream: Stream[A])(fn: A => Stream[B]): Stream[B] =
    stream.foldRight(empty[B]) { (a, acc) =>
      append(fn(a), acc)
    }
}
