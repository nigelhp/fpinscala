import scala.annotation.tailrec

import fpinscala.datastructures._

/*
 * Exercise 3.10
 * Our implementation of foldRight is not tail-recursive and will result in a StackOverflowError for large lists
 * (we say it's not stack-safe).  Convince yourself that this is the case, and then write another general list-recursion
 * function, foldLeft, that is tail-recursive, using the techniques we discussed in the previous chapter.  Here is its
 * signature:
 * def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B
 */
object Exercise3_10 {

  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(head, tail) => foldLeft(tail, f(z, head))(f)
  }
}
