import fpinscala.datastructures._

/*
 * Exercise 3.28
 * Write a function map, analogous to the method of the same name on List, that 
 * modifies each element in a tree with a given function.
 */
object Exercise3_28 {

  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
    case Leaf(a) => Leaf(f(a))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }
}
