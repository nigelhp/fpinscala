import fpinscala.datastructures._

/*
 * Exercise 3.29
 * Generalize size, maximum, depth, and map, writing a new function fold that 
 * abstracts over their similarities.
 * Reimplement them in terms of this more general function.
 * Can you draw an analogy between this fold function and the left and right 
 * folds for List?
 */
object Exercise3_29 {

  def fold[A, B](tree: Tree[A])(foldLeaf: A => B)(acc: (B, B) => B): B = tree match {
    case Leaf(value) => foldLeaf(value)
    case Branch(left, right) =>
      val foldSubtree = (subtree: Tree[A]) => fold(subtree)(foldLeaf)(acc)
      acc(foldSubtree(left), foldSubtree(right))
  }

  def size[A](tree: Tree[A]): Int = {
    fold(tree)(_ => 1)((leftSize, rightSize) => leftSize + rightSize + 1)
  }

  def maximum(tree: Tree[Int]): Int = {
    fold(tree)(i => i)((leftMax, rightMax) => leftMax.max(rightMax))
  }

  def pathLength[A](tree: Tree[A]): Int = {
    fold(tree)(_ => 1)((leftLength, rightLength) => leftLength.max(rightLength) + 1)
  }

  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = {
    val mapLeaf = (value: A) => Leaf(f(value)): Tree[B]
    val acc = (left: Tree[B], right: Tree[B]) => Branch(left, right): Tree[B]
    fold(tree)(mapLeaf)(acc)
  }
}
