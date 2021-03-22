package exercises

/*
This solution is dangerous, since it works based on the mutability of an object Node,
going against the functional programming principles.
Glad I could still apply some tail recursion knowledge from the course though.
Saving this code just as a reminder.
 */

import scala.annotation.tailrec

/*
    head = fists element of this list OK
    tail = remainder of the list Ok
    isEmpty = is this list empty OK
    add(int) => new list with this element added
    toString => a string representation of the list OK
*/

class MyList(val valArray: Array[Int]) {

  class Node(val value: Int = 0, var next: Node = null)

  var linkedStructure: Node = new Node(valArray.head)

  def apply():Unit = {
    @tailrec
    def listBuilderHelper(x: Int, primeNode: Node): Node = {
      if (x >= valArray.length) primeNode
      else {
        primeNode.next = new Node(valArray(x), new Node)
        listBuilderHelper(x + 1, primeNode.next)
      }
    }

    listBuilderHelper(1, linkedStructure)
  }

  override def toString: String = {
    @tailrec
    def concatStringHelper(node: Node, stringAccumulator: String, x: Int): String = {
      if (x >= valArray.length) stringAccumulator
      else
        if (x == 0)
          concatStringHelper(
            node.next,
            s"$stringAccumulator${node.value}",
            x + 1
          )
        else
          concatStringHelper(
            node.next,
            s"$stringAccumulator => ${node.value}",
            x + 1
          )
    }

    concatStringHelper(linkedStructure, "", 0)
  }

  def addToHead(value: Int): MyList = {
    val newList = new MyList(value +: valArray)
    newList()

    newList
  }

  def addToTail(value: Int): MyList = {
    val newList = new MyList(valArray :+ value)
    newList()

    newList
  }

}

object Main extends App {
  val MyList = new MyList(Array(1, 2, 3, 4, 5, 30))
  MyList()
  println(MyList.toString)

  val newHeadList = MyList.addToHead(100)
  println(newHeadList.toString)

  val newTailList = MyList.addToTail(100)
  println(newTailList.toString)
}
