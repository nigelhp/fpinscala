import Exercise3_12.reverse
import fpinscala.datastructures._

/*
 * Exercise 3.13
 * Can you write foldLeft in terms of foldRight?
 * How about the other way round?
 * Implementing foldRight via foldLeft is useful because it lets us implement foldRight tail-recursively, which means
 * it works even for large lists without overflowing the stack.
 */
object Exercise3_13 {

  def foldLeft[A, B](list: List[A], acc:B)(f: (B, A) => B): B = {
    Exercise3_7.foldRight(reverse(list), acc)((e, acc) => f(acc, e))
  }

  def foldRight[A, B](list: List[A], acc: B)(f: (A, B) => B): B = {
    Exercise3_10.foldLeft(reverse(list), acc)((acc, e) => f(e, acc))
  }
}
