package com.github.nigelhp.fpinscala

import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 9.1
 * Using product, implement the now familiar combinator map2 and then use this to implement many1 in
 * terms of many.
 *   def map2[A,B,C](p: Parser[A], p2: Parser[B])(f: (A,B) => C): Parser[C]
 */
trait Exercise9_1[ParseError, Parser[+_]] extends Parsers[ParseError, Parser] {
  override def map2[A, B, C](p: Parser[A], p2: Parser[B])(f: (A, B) => C): Parser[C] = {
    val parser = product(p, p2)
    map(parser)(f.tupled)
  }

  override def many1[A](p: Parser[A]): Parser[List[A]] =
    map2(p, many(p)) { (a, manyA) => a :: manyA }
}
