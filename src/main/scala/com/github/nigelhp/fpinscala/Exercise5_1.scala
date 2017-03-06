package com.github.nigelhp.fpinscala

import fpinscala.laziness._

/*
 * Exercise 5.1
 * Write a function to convert a Stream to a List, which will force its evaluation
 * and let you look at it in the REPL.  You can convert to the regular List type in
 * the standard library.
 */
object Exercise5_1 {
  def toList[A](stream: Stream[A]): List[A] =
    stream match {
      case Empty => Nil
      case Cons(h, t) => h() :: toList(t())
    }
}
