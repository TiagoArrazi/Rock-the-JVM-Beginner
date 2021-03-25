package lectures.part3fp

object AnonymousFunctions extends App {

  // val doubler = new Function[Int, Int] {
  //   override def apply(v1: Int): Int = v1 * 2
  // }

  // anonymous function (LAMBDA)
  // val doubler = (v1: Int) => v1 * 2
  val doubler: Int => Int = v1 => v1 * 2

  // multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MOARRR syntatic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
  1. MyList: replace all FunctionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous function
  */

  // 1.
  // ***

  // 2.
  val superAdder = (v1: Int) => (v2: Int) => v1 + v2
  println(superAdder(3)(4))




}
