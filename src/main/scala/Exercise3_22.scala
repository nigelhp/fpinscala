import fpinscala.datastructures._

/*
 * Exercise 3.22
 * Write a function that accepts two lists and constructs a new list by adding corresponding elements.
 * For example, List(1, 2, 3) and List(4, 5, 6) become List(5, 7, 9).
 */
object Exercise3_22 {

//  def zipAdd(xs: List[Int], ys: List[Int]): List[Int] = {
//    xs match {
//      case Nil => Nil
//      case Cons(xh, xt) => ys match {
//        case Nil => Nil
//        case Cons(yh, yt) => Cons(xh + yh, zipAdd(xt, yt))
//      }
//    }
//  }

  // introducing a pair, and pattern-matching on that results in a cleaner approach than nested pattern matches (above)
  def zipAdd(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(xh, xt), Cons(yh, yt)) => Cons(xh + yh, zipAdd(xt, yt))
  }
}
