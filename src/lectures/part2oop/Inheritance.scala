package lectures.part2oop

object Inheritance extends App{

  // single class inheritance
  // private: can only accessed within the class
  // protected: can be accessed within the class and its subclasses
  sealed class Animal {
    val creatureType = "wild"
    def eat(): Unit = println("nom nom nom")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch()

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat(): Unit = {
      super.eat()
      println("crunch crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat()
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat()

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1. use keyword "final" on member
  // 2. use keyword "final" on the entire class
  // 3. seal the class = extend classes in THIS FILE, prevent extension in other files

}
