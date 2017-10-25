package com.github.nigelhp.fpinscala

import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 9.7
 * Implement product and map2 in terms of flatMap.
 */
trait Exercise9_7[ParseError, Parser[+_]] extends Parsers[ParseError, Parser] {

  override def product[A,B](p: Parser[A], p2: => Parser[B]): Parser[(A, B)] =
    map2(p, p2) { (a, b) =>
      a -> b
    }

  override def map2[A,B,C](p: Parser[A], p2: => Parser[B])(f: (A, B) => C): Parser[C] =
    flatMap(p) { a =>
      map(p2) { b =>
        f(a, b)
      }
    }
}
