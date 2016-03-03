import scala.annotation.tailrec

/*
 * Exercise 2.2
 * Implement isSorted, which checks whether an Array[A] is sorted
 * according to a given comparison function:
 *
 * def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean
 */
object Exercise2_2 {

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def loop(a: A, remaining: Array[A]): Boolean = {
      if (remaining.isEmpty) true
      else if (ordered(a, remaining.head))
        loop(remaining.head, remaining.tail)
      else false
    }

    if (as.isEmpty) true
    else loop(as.head, as.tail)
  }
}
