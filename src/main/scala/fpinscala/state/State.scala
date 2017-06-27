package fpinscala.state

case class State[S, +A](run: S => (A, S))

object State {
  type State[S, +A] = S => (A, S)
}
