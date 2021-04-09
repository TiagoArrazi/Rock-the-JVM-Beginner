package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // Exercise: print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val characters = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
  // List("a1", "a2", ... , "d3", "d4")

  // "iterations"
  val combinations = numbers.flatMap(n => characters.map(c => c + n.toString))
  println(combinations)

  // "iterations"
  val moreCombinations = numbers.flatMap(n => characters.flatMap(c => colors.map(col => c + n.toString + "-" + col)))
  println(moreCombinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- characters
    col <- colors
  } yield c + n.toString + "-" + col
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
  1. MyList supports for comprehensions?
  2. A small collection of at most ONE element - Maybe[+T]
   */

  // 1.
  /*
  methods inside MyList must have the following signatures

    map(f: A => B) => MyList[B]
    filter(p: A => Boolean) => MyList[A]
    flatMap(f: A => MyList[B]) => MyList[B]
   */

  // 2.
  // src.exercises.Maybe
}
