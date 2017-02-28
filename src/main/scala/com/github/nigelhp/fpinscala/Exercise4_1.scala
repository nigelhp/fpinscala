package com.github.nigelhp.fpinscala.exercise4_1

/*
 * Exercise 4.1
 * 
 * trait Option[+A] {
 *   def map[B](f: A => B): Option[B]
 *   def flatMap[B](f: A => Option[B]): Option[B]
 *   def getOrElse[B >: A](default: => B): B
 *   def orElse[B >: A](ob: => Option[B]): Option[B]
 *   def filter(f: A => Boolean): Option[A]
 * }
 * 
 * Implement all of the preceding functions on Option.  As you implement each
 * function, try to think about what it means and in what situations you'd use
 * it.
 * Here are a few hints for solving this exercise:
 * - It's fine to use pattern matching, though you should be able to implement
 *   all the functions besides map and getOrElse without resorting to pattern
 *   matching.
 * - For map and flatMap, the type signature should be enough to determine the
 *   implementation.
 * - getOrElse returns the result inside the Some case of the Option, or if the
 *   Option is None, returns the given default value.
 * - orElse returns the first Option if it's defined; otherwise, it returns the
 *   second Option.   
 */

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] =
    this match {
      case None => None
      case Some(value) => Some(f(value))
    }

  // using pattern-matching
  // def flatMap[B](f: A => Option[B]): Option[B] =
  //   this match {
  //     case None => None
  //     case Some(value) => f(value)
  //   }

  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f).getOrElse(None)

  def getOrElse[B >: A](default: => B): B =
    this match {
      case None => default
      case Some(value) => value
    }

  // using pattern-matching
  // def orElse[B >: A](ob: => Option[B]): Option[B] =
  //   this match {
  //     case None => ob
  //     case Some(_) => this
  //   }

  def orElse[B >: A](ob: => Option[B]): Option[B] =
    map(Some(_)).getOrElse(ob)

  // using pattern-matching
  // def filter(f: A => Boolean): Option[A] =
  //   this match {
  //     case Some(value) if f(value) => this
  //     case _ => None
  //   }

  def filter(f: A => Boolean): Option[A] =
    flatMap(a => if (f(a)) Some(a) else None)
}

case object None extends Option[Nothing]
case class Some[+A](value: A) extends Option[A]
