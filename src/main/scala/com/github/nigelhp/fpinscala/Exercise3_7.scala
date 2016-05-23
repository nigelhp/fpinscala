package com.github.nigelhp.fpinscala

import scala.annotation.tailrec

import fpinscala.datastructures._

/*
 * Exercise 3.7
 * Can product, implemented using foldRight, immediately halt the recursion and return 0.0 if it
 * encounters a 0.0?  Why or why not?
 * Consider how any short-circuiting might work if you call foldRight with a large list.
 * This is a deeper question that we'll return to in chapter 5.
 */
object Exercise3_7 {

  def sumLeft(as: List[Int]): Int = foldLeft(as, 0)((acc, i) => acc + i)
  def productLeft(as: List[Int]): Int = foldLeft(as, 1)((acc, i) => acc * i)

  @tailrec
  def foldLeft[A, B](as: List[A], acc: B)(f: (B, A) => B): B = as match {
    case Nil => acc
    case Cons(head, tail) => foldLeft(tail, f(acc, head))(f)
  }


  def sumRight(as: List[Int]): Int = foldRight(as, 0)((i, acc) => i + acc)
  def productRight(as: List[Int]): Int = foldRight(as, 1)((i, acc) => i * acc)

  def foldRight[A, B](as: List[A], acc: B)(f: (A, B) => B): B = as match {
    case Nil => acc
    case Cons(head, tail) => f(head, foldRight(tail, acc)(f))
  }
}

/*
 * Product, when implemented via foldRight, cannot immediately halt the recursion if it encounters a 0.0 value.
 * The recursive nature of foldRight means that the entire list is traversed as foldRight evaluates its arguments,
 * before the function supplied by product is ever invoked.
 */
