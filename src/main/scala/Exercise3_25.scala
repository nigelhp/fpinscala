import fpinscala.datastructures._

/*
 * Exercise 3.25
 * Write a function size that counts the number of nodes (leaves and branches) 
 * in a tree.
 */
object Exercise3_25 {

  def size[A](tree: Tree[A]): Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => size(l) + size(r) + 1
  }
}
