package com.github.nigelhp.fpinscala

import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 9.3
 * See if you can define many in terms of or, map2, and succeed.
 */
trait Exercise9_3[ParseError, Parser[+_]] extends Parsers[ParseError, Parser] {

  override def many[A](p: Parser[A]): Parser[List[A]] = {
    val parser = map2(p, many(p))(_ :: _)
    or(parser, succeed(List.empty))
  }
}
