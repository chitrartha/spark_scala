package Section3

object Section3_Exceptions_Lecture22 extends App {

  val x: String = null
  //println(x.length)
  //^ This will crash with NPE

  //1. throwing and catching exception

  //val aWeirdValue: String = throw new NullPointerException
  //The return type of 'throw new NullPointerException' is Nothing but since it is a expression as like any other thing in scala awe can assign it to a value and have the
  //return type of the value as string as Evry dat type is subset of Nothing.

  //throwable classes extend the throwable class
  //Exception and error are the major throwable subtypes.


  //2. How to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42

  val potentialFail = try{
    //code that might throw
    getInt(true)
  }catch{
    case e : RuntimeException => println("Caught a runtime exception")
    //Actually it should be 'RuntimeException' instead of 'NullPointerException'. But ity is to show that it will throw the RuntimeException but none will be catched.
    //Observe the error message displayed after running of the code.|Exception in thread "main" java.lang.RuntimeException: No Int for you
  } finally{
    //code that will be executed no matter what
    //optional
    //does not influence the return type of this expression
    //use finally only for side effects.
    println("finally")
  }


  //3.How to define your own exceptions?
//  class MyException extends Exception
//  val exception = new MyException
//  throw exception

  //These are th exceptions.
  /*
  1.Crash your program with OutOfMemoryError.

  2.Crash your program with StackOverflowError.

  3.PocketCalculator:
    -add(x,y)
    -multiply(x,y)
    -divide(x,y)
    -substract(x,y)

    Throw
      -overflowException if add(x,y) exceeds Int.MAX_VALUE
      -underflowException if substract(x,y) exceeds Int.MIN_VALUE
      -mathCalculationException for divison by 0.
   */

  //val array = Array.ofDim(Int.MaxValue)
  //^ This will throw OOM.
  println(Int.MaxValue)

  //SO
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite



  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      //If the positive integer exceeds the maxvalue it returns the negative value.
      //If the negative integer exceeds the minvalue it returns the positive value.
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result

    }

    def substrtact(x: Int, y: Int) = {
      val result = x - y

      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result

    }

    def multiply(x: Int, y: Int) = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divison(x: Int, y: Int) = {
      val result = x / y

      if (y == 0) throw new MathCalculationException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

  }


  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divison(2, 0))
  //2147483647


}
