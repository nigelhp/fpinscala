import fpinscala.datastructures._

/*
 * Exercise 3.5
 * Implement dropWhile, which removes elements from the List prefix as long as they match a predicate.
 *
 * def dropWhile[A](l: List[A], f: A => Boolean): List[A]
 */
object Exercise3_5 {

  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(h, t) => if (f(h)) dropWhile(t, f) else Cons(h, t)
  }
}
