package com.github.nigelhp.fpinscala

import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 9.4
 * Using map2 and succeed, implement the listOfN combinator.
 */
trait Exercise9_4[ParseError, Parser[+_]] extends Parsers[ParseError, Parser] {

  override def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]] = {
    require (n >= 0)
    n match {
      case 0 => succeed(List.empty[A])
      case _ => map2(p, listOfN(n - 1, p))(_ :: _)
    }
  }
}
