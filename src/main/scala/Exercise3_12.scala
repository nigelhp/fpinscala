import fpinscala.datastructures._
import Exercise3_10.foldLeft

/*
 * Exercise 3.12
 * Write a function that returns the reverse of a list (given List(1, 2, 3) it returns List(3, 2, 1)).
 * See if you can write it using a fold.
 */
object Exercise3_12 {

  def reverse[A](list: List[A]): List[A] = foldLeft(list, Nil: List[A])((acc, e) => Cons(e, acc))
}
