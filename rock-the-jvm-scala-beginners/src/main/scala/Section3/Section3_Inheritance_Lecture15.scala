package Section3

object Section3_Inheritance_Lecture15 extends App {

  //Single class inheritance
  class Animal{

    val creatureType = "wild"
    val animalType = "anything"
    protected def eat = println("momnom") //Only accessible to class and its subcalss
    private def drink = print("slurpp") //Only accessible to its own class

  }

  class Cat extends Animal{
    def crunch = {
      eat
      //drink  //Inaccessible as it is private
    }

  }

  val cat = new Cat
  cat.crunch
  //momnom


  //constructors
  class Person(name: String, age: Int){
    def this(name: String) = {this(name,0)} //auxillary constructor
  }
  //class Adult(name: String, age: Int, idCard: String) extends Person
  //Above will not work; Unspecified parameter. Because when you try to instantiate a Adult object, JVM will call Person constructor 1st, before you call teh constructor of Adult.
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) //correct way
  //class Adult(name: String, age: Int, idCard: String) extends Person(name) //Or we can also call teh auxillary contructor of parent class.; If we use auxillary constructor in parent class.


  //Overriding
  class Dog(override val creatureType: String) extends Animal {

    override val animalType = "mammal"
    override def eat = println("crunch crunch")
    super.eat
    //momnom
  }

  val dog = new Dog("domestic")
  dog.eat
  //crunch crunch
  println(dog.animalType)//override in scope of class
  println(dog.creatureType)// override in class parameter

  //substitution (broad: polymorphism)
  val unknownAnimal = new Dog("domestic")
  unknownAnimal.eat

  //Overirding(Different implementation in diff classes; Method call will go to most overriden version whenever possible) vs Overloading

  //Super

  //Preventing overrides
  //use 1 - final on member
  //use 2 - final on the entire class [final class Animal]
  //use 3 - seal the class = extend classes in this file only but prevents in other files. [sealed class Animal]
}
