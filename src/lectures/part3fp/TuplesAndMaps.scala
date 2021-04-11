package lectures.part3fp

import java.io

object TuplesAndMaps extends App{

  // Tuples = finite ordered "lists"
  val aTuple = Tuple2(2, "Hello, Scala") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple._2)
  println(aTuple.copy(_2 = "Goodbye, Java"))
  println(aTuple.swap)

  // Maps: keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map("Jim" -> 555, "Daniel" -> 789).withDefaultValue(-1) // a -> b is sugar for (a,b)
  println(phonebook)

  // Map operations
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
  1. What would happen if I had two original entries "Jim" -> 555 and "Jim" -> 900?
  2. Overly simplified social network based on maps
    Person = String
    - add a person to the network
    - remove a person
    - friend (mutual)
    - unfriend (mutual)
    - number of friends of a person
    - person with most friends
    - how many people with no friends
    - if there is a social connection between two people (direct or not)
   */

  // 1.
  println(Map("Jim" -> 555, "JIM" -> 999).map(pair => pair._1.toLowerCase -> pair._2))
  // it keeps the last key -> value
  // Map("jim" -> 999)

  // 2.
  val myNetwork: Map[String, List[String]] = Map().withDefaultValue(List())

  def add(network: Map[String, List[String]], person: String): Map[String, List[String]] = {
    val newPerson = person -> List()
    network + newPerson
  }

  def remove(network: Map[String, List[String]], person: String): Map[String, List[String]] = network - person

  def friend(network: Map[String, List[String]], person: String, friend: String): Map[String, List[String]] = {
    val newNetwork = network.updated(person, network(person) :+ friend)
    newNetwork.updated(friend, newNetwork(friend) :+ person)
  }

  def unfriend(network: Map[String, List[String]], person: String, friend: String): Map[String, List[String]] = {
    val newNetwork = network.updated(person, network(person).filter(_ != friend))
    newNetwork.updated(friend, newNetwork(friend).filter(_ != person))
  }

  def numberOfFriends(network: Map[String, List[String]], person: String): Int = network(person).length
  def mostFriends(network: Map[String, List[String]]): String = network.maxBy(_._2.length)._1
  def noFriends(network: Map[String, List[String]]): Int = network.toList.count(_._2.isEmpty)

  def findSocialConnection(network: Map[String, List[String]], person: String, friend: String): List[String] =
    network(person) intersect network(friend)

  val n1 = add(myNetwork, "Jim")
  val n2 = add(n1, "Julia")
  val n3 = add(n2, "Carol")
  val n4 = friend(n3, "Jim", "Carol")
  val n5 = friend(n4, "Jim", "Julia")
  val n6 = unfriend(n5, "Julia", "Jim")
  val n7 = friend(n6, "Jim", "Julia")
  val n8 = add(n7, "Josh")
  println(n8)

  println(findSocialConnection(n8, "Julia", "Carol"))
  println(findSocialConnection(n8, "Jim", "Carol"))
  println(findSocialConnection(n8, "Josh", "Jim"))

}
