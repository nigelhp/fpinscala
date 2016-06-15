package com.github.nigelhp.fpinscala.exercise4_6

/*
 * Exercise 4.6
 * Implement versions of map, flatMap, orElse, and map2 on Either that operate
 * on the Right value.
 * 
 * trait Either[+E, +A] {
 *   def map[B](f: A => B): Either[E, B]
 *   def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]
 *   def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B]
 *   def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C]
 * }
 */

sealed trait Either[+E, +A] {
  def map[B](f: A => B): Either[E, B] = this match {
    case Left(e) => Left(e)
    case Right(a) => Right(f(a))
  }

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
    case Left(e) => Left(e)
    case Right(a) => f(a)
  }

  def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
    case Left(_) => b
    case Right(_) => this
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
    this match {
      case Left(e) => Left(e)
      case Right(a) => b.map(f(a, _))
    }
}

case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]
