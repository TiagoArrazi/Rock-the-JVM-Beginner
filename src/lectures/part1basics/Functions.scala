package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }
  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n + 1)
  }

  // EXERCISES

  /*
   1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."

   2. Factorial function => 1 * 2 * 3 * ... * n

   3. Fibonacci function
    f(1) = 1
    f(2) = 1
    f(n) = f(n - 1) + f(n - 2)

   4. Tests if a number is prime
   */

  //Answers

  // 1.
  def greetingFunction(aName: String, anAge: Int): String = {
    s"Hi, my name is $aName and I am $anAge years old."
  }

  // 2.
  def factorialFunction(n: Int): Int = {
    if (n <= 0) 1
    else
      n * factorialFunction(n - 1)
  }
  println(factorialFunction(5))
  println(factorialFunction(10))

  // 3.
  def fibonacciFunction(n: Int): Int = {
    if (n == 1 || n == 2) 1
    else
      fibonacciFunction(n - 1) + fibonacciFunction(n - 2)
  }
  println(fibonacciFunction(5))
  println(fibonacciFunction(10))

  // 4.
  // MY ANSWER
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

  // INSTRUCTOR'S ANSWER
  def isPrimeInstructor(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

}
