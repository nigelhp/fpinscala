package com.github.nigelhp.fpinscala

import fpinscala.laziness._

import scala.annotation.tailrec

/*
 * Exercise 5.2
 * Write a function take(n) for returning the first n elements of a stream, and drop(n) for skipping
 * the first n elements of a Stream.
 */
object Exercise5_2 {
  def take[A](stream: Stream[A], n: Int): Stream[A] =
    stream match {
      case Cons(h, t) if n > 1 => Stream.cons(h(), take(t(), n - 1))
      case Cons(h, _) if n == 1 => Stream.apply(h())
      case _ => Stream.empty
    }

  @tailrec
  def drop[A](stream: Stream[A], n: Int): Stream[A] =
    stream match {
      case Cons(_, t) if n > 0 => drop(t(), n - 1)
      case _ => stream
    }
}
