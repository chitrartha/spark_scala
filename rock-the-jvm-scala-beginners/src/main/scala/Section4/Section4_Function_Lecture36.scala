package Section4

object Section4_Function_Lecture36 extends App{

  //use functions as first class elements
  //problem : oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))
  //doubler which is like instance of 'function like' class can be called like function.

  //Function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  //scala supports thi skind of function till 22 paramaters
  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //The type of adder is ((Int, Int) => Int) which is syntactic sugar for function2. so we can also write the adder as:
  //val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int]

  //Function types Function[A, B, R] === (A, B) => R

  //ALL SCALA FUNCTIONS ARE OBJECTS


  /*
  1. a functoin which takes 2 strings and concatenates them.
  2. trasform the MyTransformer and MyPredicate into function types.
  3. define a function which takes an int and returns another function which takes an int and returns an int.
    -whats the type of the function
    -how to do it.
   */

  //1.
  val concatanetor = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatanetor("Hello", "Scala"))

  //2.
  // Section4_Funtcion_Lecture36_MyList.scala

  //3.
  val superAdderValue: Function1[Int, Function1[Int, Int]] = {new Function1[Int, Function1[Int, Int]] {
    override def apply(a: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(b: Int) =  a + b
    }
  }
  }

  def superAdderFunction = {new Function[Int, (Int => Int)] {
    override def apply(a: Int) =  new Function[Int, Int] {
      override def apply(b: Int) =  a + b
    }
  }
  }

  println(superAdderValue(3)(4))
  println(superAdderFunction(2)(3)) //curried function



}

class Action{
  def execute(element: Int): String = ???
}

//This trait is like a functino like trait. In Functional prog. we can use class/traits as 'functions like'.
trait MyFunction[A, B]{
  def apply(element: A): B = ???
}