package fpinscala.parsers

import scala.language.higherKinds

trait Parsers[ParseError, Parser[+_]] { self =>
  def run[A](p: Parser[A])(input: String): Either[ParseError, A]

  def char(c: Char): Parser[Char]
  def string(s: String): Parser[String]
  def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]]

  def or[A](s1: Parser[A], s2: Parser[A]): Parser[A]
  def many[A](p: Parser[A]): Parser[List[A]]
  def map[A,B](a: Parser[A])(f: A => B): Parser[B]

  def slice[A](p: Parser[A]): Parser[String]
  def many1[A](p: Parser[A]): Parser[List[A]]
  def product[A,B](p: Parser[A], p2: Parser[B]): Parser[(A, B)]

  def succeed[A](a: A): Parser[A] =
    map(string(""))(_ => a)
}
