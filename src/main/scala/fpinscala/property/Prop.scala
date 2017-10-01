package fpinscala.property

trait Prop {
  def check: Boolean
  def &&(p: Prop): Prop
}

object Prop {
  def forAll[A](a: Gen[A])(f: A => Boolean): Prop = ???
}
