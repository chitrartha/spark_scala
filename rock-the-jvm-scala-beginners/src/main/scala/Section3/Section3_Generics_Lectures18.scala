//package Section3
//
//object Section3_Generics_Lectures18 extends App{
//
//  class MyList[+A]{
//
//    //Use the type A
//    def add(element: A): MyList[A] = ??? //This wont work for covarinat class implementaion due to HARD QUESTIONS at line no. 49, thats why we
//    //implement this at line no.10
//
//    def add[B >: A](element: B): MyList[B] = ???
//
//
//    /*
//    A= Cat
//    B= Animal
//     */
//
//  }
//
//  class MyMap[Key, Value]
//  val listOfIntegers = new MyList[Int]
//  val listOfStrings = new MyList[String]
//
//  //Generic methods
//  object MyList{
//
//    //Objects cannot be type parameterized.
//    def Empty[A]: MyList[A]= ??? //Method signature -> Type parametrized with generic parameter. Empty here is the generic method.
//
//  }
//
//  val emptyListOfIntegers = MyList.Empty[Int]
//  //ctrl + shift + p will show type in mac.
//
//  //variance problem
//
//  class Animal
//
//  class Cat extends Animal
//
//  class Dog extends Animal
//
//
//  //1.yes List[Cat] extends List[Animals] = covariance
//  class CovariantList[+A]
//  val animal:Animal = new Cat
//  //val cat:Cat = new Animal //not possible
//  val animalList: CovariantList[Animal] = new CovariantList[Cat]
//  //animalList.add(new Dog) ??? HARD QUESTIONS
//  //Since animalList is a list of animals we should be able to add Dog, but that in turn will corrupt the list which only has cat.
//  //but answer to the HARD QUESTIONS is that it will convert to list of animals. As cat and dogs both are animals. Technical implementation of this is at line no. 8. When we add Animal object which is super
//  //to Cat object. Then the list returned becomes list of Animals.
//
//  //2.No = invariance
//  class InvariantList[A]
//  val invartiantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
//
//  //3.Hell NO! = contravariance
//  class ContravariantList[-A]
//  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
//  //In the covariance, we are replacing list of animals with list of cat, because cats are animals. But in contravariance, we are replacing list of cats with list of animals.
//  //This is very counter intuitive.
//
//  //But there are some use cases where contravariance can be very useful.
//  class Trainer[-A]
//  val trainer: Trainer[Cat] = new Trainer[Animal]
//  //Trainer of animal can train cat.
//
//
//  //Bounded types
//  class Cage[A <: Animal](animal :A) //This class can have any sub class of animal in its constructor.
//  val cage = new Cage(new Dog)
//
//  //class Car
//  //val car = new Cage(new Car)
//  //Error:(61, 13) inferred type arguments [Section3.Section3_Lectures17.Car] do not conform to class Cage's type parameter bounds [A <: Section3.Section3_Lectures17.Animal]
//
//
//  //Expand the MyLIst to be generic
//
//
//
//
//
//
//}
