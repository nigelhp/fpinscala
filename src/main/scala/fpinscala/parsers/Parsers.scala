package fpinscala.parsers

import scala.language.higherKinds
import scala.util.matching.Regex

trait Parsers[ParseError, Parser[+_]] { self =>
  def run[A](p: Parser[A])(input: String): Either[ParseError, A]

  def char(c: Char): Parser[Char]
  def string(s: String): Parser[String]
  def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]]

  def or[A](p: Parser[A], p2: => Parser[A]): Parser[A]
  def many[A](p: Parser[A]): Parser[List[A]]
  def map[A,B](a: Parser[A])(f: A => B): Parser[B]

  def slice[A](p: Parser[A]): Parser[String]
  def many1[A](p: Parser[A]): Parser[List[A]]
  def product[A,B](p: Parser[A], p2: => Parser[B]): Parser[(A, B)]
  def map2[A,B,C](p: Parser[A], p2: => Parser[B])(f: (A, B) => C): Parser[C]

  def succeed[A](a: A): Parser[A] =
    map(string(""))(_ => a)

  def regex(r: Regex): Parser[String]
  def flatMap[A,B](p: Parser[A])(f: A => Parser[B]): Parser[B]
}
