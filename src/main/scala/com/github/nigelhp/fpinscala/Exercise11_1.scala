package com.github.nigelhp.fpinscala

import fpinscala.monads.Monad
import fpinscala.parallelism.Par
import fpinscala.parallelism.Par.Par
import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 11.1
 * Write monad instances for Par, Parser, Option, Stream, and List.
 */
object Exercise11_1 {
  val parMonad = new Monad[Par] {
    override def unit[A](a: => A): Par[A] = Par.lazyUnit(a)
    override def flatMap[A, B](fa: Par[A])(f: A => Par[B]): Par[B] = {
      Exercise7_13.chooser(fa)(f)
    }
  }

  type ParseError = RuntimeException
  def parserMonad[Parser[+_]](parsers: Parsers[ParseError, Parser]) = new Monad[Parser] {
    override def unit[A](a: => A): Parser[A] = parsers.succeed(a)
    override def flatMap[A, B](fa: Parser[A])(f: A => Parser[B]): Parser[B] =
      parsers.flatMap(fa)(f)
  }

  val optionMonad = new Monad[Option] {
    override def unit[A](a: => A): Option[A] = Option(a)
    override def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] =
      fa.flatMap(f)
  }

  val streamMonad = new Monad[Stream] {
    override def unit[A](a: => A): Stream[A] = Stream(a)
    override def flatMap[A, B](fa: Stream[A])(f: A => Stream[B]): Stream[B] =
      fa.flatMap(f)
  }

  val listMonad = new Monad[List] {
    override def unit[A](a: => A): List[A] = List(a)
    override def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] =
      fa.flatMap(f)
  }
}
