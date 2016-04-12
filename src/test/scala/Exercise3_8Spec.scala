import org.scalatest.FlatSpec

import fpinscala.datastructures._
import Exercise3_7.foldRight

/*
 * Exercise 3.8
 * See what happens when you pass Nil and Cons themselves to foldRight, like this:
 * foldRight(List(1,2,3), Nil:List[Int])(Cons(_,_)).
 * What do you think this says about the relationship between foldRight and the data
 * constructors of List?
 */
class Exercise3_8Spec extends FlatSpec {

  "foldRight" should "return the original list " +
    "when the starting accumulator is Nil, and the fold function applies Cons" in {
    assert(foldRight(List(1, 2, 3), Nil: List[Int])((value, acc) => Cons(value, acc)) === List(1, 2, 3))
  }
}

/*
 * foldRight(List(1, 2, 3), Nil)(Cons(_, _))
 * Cons(1, foldRight(List(2, 3), Nil)(Cons(_, _)))
 * Cons(1, Cons(2, foldRight(List(3), Nil)(Cons(_, _))))
 * Cons(1, Cons(2, Cons(3, foldRight(Nil, Nil)(Cons(_, _)))))
 * Cons(1, Cons(2, Cons(3, Nil)))
 * Cons(1, Cons(2, List(3)))
 * Cons(1, List(2, 3))
 * List(1, 2, 3)
 *
 * A List represents a singly-linked list of Cons elements.
 * By folding from right to left, and using Cons to add each element to the accumulator,
 * we reconstitute the original list.
 */
