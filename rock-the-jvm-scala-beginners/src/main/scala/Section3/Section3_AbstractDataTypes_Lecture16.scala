package Section3

object Section3_AbstractDataTypes_Lecture16 extends App {


  //abstract

  abstract class Animal{

    //abstract classes cannot be instantiated. Makes sense bacause it will have no field to instantiate. It is meant to be extended by its sub class.
    //It can have both abstract and non-abstract member.
    val creatureType: String = "wild" //non-abstract member
    def eat: Unit // abstract member

  }

  class Dog extends Animal{

    override val creatureType: String= "K9"
    def eat: Unit = println("crunch") //we can use override keyword or we cannot. It will automatically figure out.
  }


  //traits
  //It can also have both abstract and non-abstract member.

  trait Carnivore {
    def eat(animal: Animal): Unit // abstract member
    val preferedMeal: String = "fresh meat" //non-abstract member
  }

  class Crocodile extends Animal with Carnivore{

    override val creatureType: String= "croc"
    def eat: Unit = "nomnon"
    def eat(animal: Animal): Unit = println(s"i am a croc and i am eating ${animal.creatureType}")

  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  //trait vs absrtact classes
  //1. Trait can have no constructor parameter.
  //2. Multiple Traits can be inhereted by a class.
  //3. Trait are behaviour; But abstract class are "things"

  //Any, AnyVal, AnyRef, scala.Nothing, scala.Null

}
