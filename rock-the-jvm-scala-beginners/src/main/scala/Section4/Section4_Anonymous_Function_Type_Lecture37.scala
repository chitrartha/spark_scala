package Section4

object Section4_Anonymous_Function_Type_Lecture37 extends App{

  val doubler = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  //This is much simpler way to write anonymous function
  //LAMBDA
  val doublerAnonymous = (x:Int) => x * 2 // WE can actually add Int => Int type as it is infered by scala.
  val doublerOther: Int => Int = x => x * 2

  //multiple params in lambda
  val adder: ((Int, Int) => Int) = (a: Int, b: Int) =>  a + b
  //TIP: Always surround the type of function  by () and then in initializing anonymous function also use ().

  //no params
  val justDoSomething = () => 3
  val justDoSomethingAnother: () => Int = () => 3

  //careful
  println(justDoSomethingAnother) //function itself
  println(justDoSomethingAnother()) //call
  //Always call the anonymous fucntion with paranthesis.

  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MOAR syntactic sugar
  val niceIncrementaor: Int => Int = _ + 1 // (x: Int) => x + 1
  val adderAgain: (Int, Int) => Int =  _ + _ // (a: Int, b: Int) =>  a + b or (a,b) => a + b
  //If we delete the type of parameter then _ cannot determine the return type.


  /*
  1.MyLIst: Replace all FunctionX calls with lambdas
  2.Rewrite the "special" adder as an anonymous function.
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))





}
