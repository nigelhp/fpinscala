package fpinscala.property

trait Gen[A] {
  def map[B](f: A => B): Gen[B]
  def flatMap[B](f: A => Gen[B]): Gen[B]
}

object Gen {
  def listOf[A](a: Gen[A]): Gen[List[A]] = ???
  def listOfN[A](n: Int, a: Gen[A]): Gen[List[A]] = ???
}
