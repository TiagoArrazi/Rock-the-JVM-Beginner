package exercises

/*
    head = fists element of this list
    tail = remainder of the list
    isEmpty = is this list empty
    add(T) => new list with this element added
    toString => a string representation of the list
*/

abstract class MyListGenerics[+A] {
  def head: A
  def tail: MyListGenerics[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenerics[B]
  def printElements: String
  // polymorphic call
  override def toString: String = s"[$printElements]"

  // higher-order functions
  def map[B](transformer: A => B): MyListGenerics[B]
  def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B]
  def filter(predicate: A => Boolean): MyListGenerics[A]

  // concatenation
  def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B]
}

case object EmptyGenerics extends MyListGenerics[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGenerics[B] = ConsGenerics(element, EmptyGenerics)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyListGenerics[B] = EmptyGenerics
  def flatMap[B](transformer: Nothing => MyListGenerics[B]): MyListGenerics[B] = EmptyGenerics
  def filter(predicate: Nothing => Boolean): MyListGenerics[Nothing] = EmptyGenerics

  def ++[B >: Nothing](list: MyListGenerics[B]): MyListGenerics[B] = list
}

case class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A] {
  def head: A = h
  def tail: MyListGenerics[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGenerics[B] = ConsGenerics(element, this)
  def printElements: String =
    if(t.isEmpty) s"$h"
    else s"$h ${t.printElements}"

  /*
  [1,2,3].filter(n % 2 == 0)
    [2,3].filter(n % 2 == 0)
    = new ConsGenerics(2, [3].filter(n % 2 == 0))
    = new ConsGenerics(2, Empty.filter(n % 2 == 0))
    = new ConsGenerics(2, Empty)
   */
  def filter(predicate: A => Boolean): MyListGenerics[A] =
    if (predicate(h)) ConsGenerics(h, t.filter(predicate))
    else t.filter(predicate)

  /*
  [1,2,3].map(n * 2)
    = new ConsGenerics(2, [2, 3].map(n * 2))
    = new ConsGenerics(2, new ConsGenerics(4, [3].map(n * 2)))
    = new ConsGenerics(2, new ConsGenerics(4, new ConsGenerics(6, Empty.map(n * 2))))
    = new ConsGenerics(2, new ConsGenerics(4, new ConsGenerics(6, Empty)))
   */
  def map[B](transformer: A => B): MyListGenerics[B] =
    ConsGenerics(transformer(h), t.map(transformer))

  /*
  [1,2] ++ [3,4,5]
    = new ConsGenerics(1, [2] ++ [3,4,5])
    = new ConsGenerics(1, new ConsGenerics(2, Empty ++ [3,4,5]))
    = new ConsGenerics(1, new ConsGenerics(2, new ConsGenerics(3, new ConsGenerics(4, new ConsGenerics(5)))))
   */
  def ++[B >: A](list: MyListGenerics[B]): MyListGenerics[B] = ConsGenerics(h, t ++ list)

  /*
  [1,2].flatMap(n => [n, n + 1])
   = [1,2] ++ [2].flatMap(n => [n, n + 1])
   = [1,2] ++ [2,3] ++ EmptyGenerics.flatMap(n => [n, n + 1])
   = [1,2] ++ [2,3] ++ EmptyGenerics
   = [1,2,2,3]
   */
  def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B] =
    transformer(h) ++ t.flatMap(transformer)
}

object ListTestGenerics extends App {
  val listOfIntegers: MyListGenerics[Int] = new ConsGenerics[Int](1, new ConsGenerics[Int](2, new ConsGenerics[Int](3, EmptyGenerics)))
  val cloneListOfIntegers: MyListGenerics[Int] = new ConsGenerics[Int](1, new ConsGenerics[Int](2, new ConsGenerics[Int](3, EmptyGenerics)))
  val anotherListOfIntegers: MyListGenerics[Int] = new ConsGenerics[Int](4, new ConsGenerics[Int](5, EmptyGenerics))
  val listOfStrings: MyListGenerics[String] = new ConsGenerics[String]("Hello", new ConsGenerics[String]("Scala", EmptyGenerics))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  // _ is equivalent to element => element
  println(listOfIntegers.map(_ * 2).toString)

  // equivalent to

  //  println(listOfIntegers.map(new MyTransformer[Int, Int] {
  //    override def apply(element: Int): Int = element * 2
  //  }).toString)

  println(listOfIntegers.filter(_ % 2 == 0).toString)

  // equivalent to

  //  println(listOfIntegers.filter(new MyPredicate[Int] {
  //    override def apply(element: Int): Boolean = element % 2 == 0
  //  }).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println(listOfIntegers.flatMap(element => new ConsGenerics[Int](element, ConsGenerics(element + 1, EmptyGenerics))).toString)

  println(cloneListOfIntegers == listOfIntegers)
}