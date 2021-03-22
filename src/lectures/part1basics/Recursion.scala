package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{

  def factorialFunction(n: Int): Int =
    if (n <= 1) 1
    else {
      println(s"Computing factorial of $n, I first need factorial of ${n - 1}")
      val result = n * factorialFunction(n - 1)
      println(s"Computed factorial of $n")

      result
    }

  // println(factorialFunction(10)) 3628800
  // println(factorialFunction(5000)) java.lang.StackOverflowError (recursion too deep)

  def anotherFactorialFunction(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, factorialAccumulator: BigInt): BigInt =
      if (x <= 1) factorialAccumulator
      else factorialHelper(x - 1, x * factorialAccumulator) // TAIL RECURSION = use a recursive call as the LAST expression

    factorialHelper(n, 1)
  }

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION


  // EXERCISES
  /*
  1. Concatenate a string n times

  2. IsPrime function tail recursive

  3. Fibonacci function tail recursive

  */

  // Answers

  // 1.
  def concatString(aString: String, n: Int): String = {
    @tailrec
    def concatStringHelper(stringAccumulator: String, x: Int): String = {
      if (x == 1) stringAccumulator
      else concatStringHelper(aString + stringAccumulator, x - 1)
    }

    concatStringHelper(aString, n)
  }
  println(concatString("abc", 3))
  println(concatString("abc", 5))
  println(concatString("abc", 7))
  println(concatString("abc", 9))

  // 2.
  @tailrec
  def isPrime(n: Int, m: Int = 2): Boolean = {

    val checkNotDivisible = {
      n % m != 0
    }

    if (m == n) true
    else {
      if(checkNotDivisible) isPrime(n, m + 1)
      else false
    }

  }
  println(isPrime(2)) // TRUE
  println(isPrime(3)) // TRUE
  println(isPrime(4)) // FALSE
  println(isPrime(5)) // TRUE
  println(isPrime(10)) // FALSE
  println(isPrime(15)) // FALSE
  println(isPrime(37)) // TRUE
  println(isPrime(2003)) // TRUE
  println(isPrime(37 * 17)) // FALSE

  // 3. INSTRUCTOR'S ANSWER
  def fibonacciFunction(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(i: Int, lastAccumulator: Int, nextToLastAccumulator: Int): Int = {
      if (i >= n) lastAccumulator
      else fibonacciTailRec(i + 1, lastAccumulator + nextToLastAccumulator, lastAccumulator)
    }

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }
  println(fibonacciFunction(5))
  println(fibonacciFunction(10))
  println(fibonacciFunction(100000))
}


