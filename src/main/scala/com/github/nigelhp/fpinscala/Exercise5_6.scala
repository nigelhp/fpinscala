package com.github.nigelhp.fpinscala

import fpinscala.laziness._

/*
 * Exercise 5.6
 * Implement headOption using foldRight.
 */
object Exercise5_6 {
  def headOption[A](stream: Stream[A]): Option[A] =
    stream.foldRight(None: Option[A])((a, _) => Some(a))
}
