/*
 * Exercise 3.13
 * Can you write foldLeft in terms of foldRight?
 * How about the other way round?
 * Implementing foldRight via foldLeft is useful because it lets us implement foldRight tail-recursively, which means
 * it works even for large lists without overflowing the stack.
 */
class Exercise3_13 {

  def foldRight[A, B](list: List[A], acc: B)(f: (A, B) => B): B = {
    
  }
}
