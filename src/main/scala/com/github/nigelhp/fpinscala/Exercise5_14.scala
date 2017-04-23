package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise5_13.{takeWhile, zipAll}
import com.github.nigelhp.fpinscala.Exercise5_4.forAll
import fpinscala.laziness._

/*
 * Exercise 5.14
 * Implement startsWith using functions you've written.
 * It should check if one Stream is a prefix of another.  For instance,
 * Stream(1,2,3) startsWith Stream(1,2) would be true.
 *   def startsWith[A](s: Stream[A]): Boolean
 */
object Exercise5_14 {
  def startsWith[A](s: Stream[A], start: Stream[A]): Boolean = {
    val prefixPairs = takeWhile(zipAll(s, start))(_._2.nonEmpty)
    forAll(prefixPairs)(pair => pair._1 == pair._2)
  }

  // A simple implementation based on direct pattern-matching (rather than the functions we have been writing) ...
//  import scala.annotation.tailrec
//  @tailrec
//  def startsWith[A](s: Stream[A], start: Stream[A]): Boolean =
//    (s, start) match {
//      case (_, Empty) => true
//      case (Cons(sH, sT), Cons(startH, startT)) if sH() == startH() => startsWith(sT(), startT())
//      case _ => false
//    }
}
