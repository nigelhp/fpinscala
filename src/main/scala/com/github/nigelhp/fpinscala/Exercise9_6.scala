package com.github.nigelhp.fpinscala

import fpinscala.parsers.Parsers

import scala.language.higherKinds

/*
 * Exercise 9.6
 * Suppose we want to parse a single digit, like '4', followed by that many 'a' characters.
 * Examples of valid input are "0", "1a", "2aa", "4aaaa" and so on.
 * This is an example of a context-sensitive grammar.
 *
 * Using flatMap and any other combinators, write the context-sensitive parser.
 * To parse the digits, you can make use of a new primitive, regex, which promotes a regular expression to a Parser.
 *   implicit def regex(r: Regex): Parser[String]
 */
trait Exercise9_6[ParseError, Parser[+_]] extends Parsers[ParseError, Parser] {
  def nOf(c: Char): Parser[List[Char]] = {
    val countParser = map(regex("""\d""".r))(_.toInt)
    flatMap(countParser) { n =>
      listOfN(n, char(c))
    }
  }
}