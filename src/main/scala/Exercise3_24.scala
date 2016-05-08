import fpinscala.datastructures._

import scala.annotation.tailrec

/*
 * Exercise 3.24
 * As an example, implement hasSubsequence for checking whether a List contains another List as a subsequence.
 * For instance, List(1, 2, 3, 4) would have List(1, 2), List(2, 3), and List(4) as subsequences, among others.
 */
object Exercise3_24 {

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    @tailrec
    def go(matched: List[A], outer: List[A], inner: List[A]): Boolean = {
      (outer, inner) match {
        case(_, Nil) => matched != Nil
        case(Nil, _) => false
        case (Cons(xh, xt), Cons(yh, yt)) =>
          if (xh == yh) go(Cons(yh, matched), xt, yt)
          else if (matched != Nil) go(Nil, Cons(xh, xt), sub)
          else go(Nil, xt, sub)
      }
    }

    go(Nil, sup, sub)
  }
}
