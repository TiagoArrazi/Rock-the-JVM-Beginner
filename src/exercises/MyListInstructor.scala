package exercises

/*
    head = fists element of this list OK
    tail = remainder of the list Ok
    isEmpty = is this list empty OK
    add(int) => new list with this element added
    toString => a string representation of the list OK
*/

abstract class MyListInstructor {
  def head: Int
  def tail: MyListInstructor
  def isEmpty: Boolean
  def add(element: Int): MyListInstructor
  def printElements: String
  // polymorphic call
  override def toString: String = s"[$printElements]"
}

object Empty extends MyListInstructor {
  def head: Int = throw new NoSuchElementException
  def tail: MyListInstructor = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyListInstructor = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyListInstructor) extends MyListInstructor {
  def head: Int = h
  def tail: MyListInstructor = t
  def isEmpty: Boolean = false
  def add(element: Int): MyListInstructor = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) s"$h"
    else s"$h ${t.printElements}"
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.head)
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)
}