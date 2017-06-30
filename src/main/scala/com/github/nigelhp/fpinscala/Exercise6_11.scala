package com.github.nigelhp.fpinscala

import com.github.nigelhp.fpinscala.Exercise6_10.State

/*
 * Ex 6.11
 * To gain experience with the use of State, implement a finite state automaton that models a simple candy dispenser.
 * The machine has two types of input: you can insert a coin, or you can turn the knob to dispense candy.
 * It can be in one of two states: locked or unlocked.
 * It also tracks how many candies are left and how many coins it contains.
 *
 *   sealed trait Input
 *   case object Coin extends Input
 *   case object Turn extends Input
 *
 *   case class Machine(locked: Boolean, candies: Int, coins: Int)
 *
 * The rules of the machine are as follows:
 * * inserting a coin into a locked machine will cause it to unlock if there's any candy left
 * * turning the knob on an unlocked machine will cause it to dispense candy and become locked
 * * turning the knob on a locked machine or inserting a coin into an unlocked machine does nothing
 * * a machine that's out of candy ignores all inputs
 *
 * The method simulateMachine should operate the machine based on the list of inputs and return the number of
 * coins and candies left in the machine at the end.  For example, if the input Machine has 10 coins and 5 candies,
 * and a total of 4 candies are successfully bought, the output should be (14, 1).
 *
 *   def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)]
 */
object Exercise6_11 {

  sealed trait Input
  case object Coin extends Input
  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  object Machine {
    def isEmpty(machine: Machine): Boolean =
      machine.candies == 0

    def nonEmpty(machine: Machine): Boolean =
      !isEmpty(machine)

    def acceptCoin(machine: Machine): Machine =
      machine.copy(locked = false, coins = machine.coins + 1)

    def acceptTurn(machine: Machine): Machine =
      machine.copy(locked = true, candies = machine.candies - 1)
  }

  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = {
    import Machine._

    State(machine => {
      val endMachine = inputs.foldLeft(machine) { (acc, input) =>
        input match {
          case Coin => acc match {
            case m @ Machine(locked, _, _) if locked && nonEmpty(m) => acceptCoin(m)
            case m @ Machine(_, _, _) => m
          }
          case Turn => acc match {
            case m @ Machine(locked, _, _) if !locked => acceptTurn(m)
            case m @ Machine(_, _, _) => m
          }
        }
      }
      ((endMachine.coins, endMachine.candies), endMachine)
    })
  }
}
