package Section3

object Section3_AnonymousClasses_Lecture19 extends App{

  abstract class Animal{

    def eat: Unit
  }


  //The below instantiation is not happening for abstrcat class even though it looks like. Actually its a anonymous class.
  //Anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = println("hahahahahaha")
  }

  /*
  //Equivalent with [Behind teh scenes]
    class anon$1 extends Animal{
    override def eat: Unit = println("hahahahahaha")
  }

  val funnyAnimalAnon = new anon$1

   */

  println(funnyAnimal.getClass)
  //class Section3.Section3_AnonymousClasses_Lecture19$$anon$1


  class Person(name: String){

    def sayHi: Unit = println(s"Hi, y name is $name")
  }

  //Anonymous classes work for both abstarct and non-abstarct data types.[LIke abov Person class is non-abstarct class.]

  val jim = new Person("Jim"){ //Always good practice to pass teh parameter to the superclass we are extending even anonymously.
    override def sayHi: Unit = println(s"Hi, my name is Jim")
  }

  jim.sayHi
}
