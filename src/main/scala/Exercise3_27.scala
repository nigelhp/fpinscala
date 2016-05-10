import fpinscala.datastructures._

/*
 * Exercise 3.27
 * Write a function depth that returns the maximum path length from the root of 
 * a tree to any leaf.
 */
object Exercise3_27 {

  def pathLength[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => pathLength(l).max(pathLength(r)) + 1
  }
}
