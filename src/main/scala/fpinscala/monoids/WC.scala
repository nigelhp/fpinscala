package fpinscala.monoids

sealed trait WC

// simplest case - no complete words yet
case class Stub(chars: String) extends WC

// number of complete words so far, with any partial words to left & right
case class Part(lStub: String, words: Int, rStub: String) extends WC
