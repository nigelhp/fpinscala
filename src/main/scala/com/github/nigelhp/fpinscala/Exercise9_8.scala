package com.github.nigelhp.fpinscala

import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 9.8
 * map is no longer primitive.
 * Express it in terms of flatMap and/or other combinators.
 */
trait Exercise9_8[ParseError, Parser[+_]] extends Parsers[ParseError, Parser] {

  def map[A,B](p : Parser[A])(f: A => B): Parser[B] =
    flatMap(p)(a => succeed(f(a)))
}
