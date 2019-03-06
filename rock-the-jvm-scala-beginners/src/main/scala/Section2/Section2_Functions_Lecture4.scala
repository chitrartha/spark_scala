package Section2

object Section2_Functions_Lecture4 extends App {
  //functions
  //  def aFunction(a: String, b: Int) : String =
  //    a + " " + b

  def aFunction(a: String, b: Int) : String = {
    a + " " + b
  }

  def aParameterless(): Int = 42
  println(aParameterless())
  println(aParameterless) // No need of putting parenthesis for parameter less fnctn.

  def aRepeatedFunction(aString : String, n: Int): String ={
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("Hello", 3))
  //When you needs loop use recursions

  //The return type for a fnctn is not mnadatory. But for recursive fnctn its mandatory. As best practice always use return type.

  def aFunctionWithSideEffects(aString: String): Unit = println("String")

  //Exampe of auxillary function
  def aBigFunction(n: Int): Int ={
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n , n-1)
  }

  //1. Greeting fnctn for kids (name, age) => "Hi my name is $name and my age is $ age"

  def greet(name : String, age : Int): String = "Hi my name is " + name + "and my age is " +  age
  println(greet("rony", 26))

  //2.Fcatorial fnctn
  def factorial(n : Int): Int ={
    if (n==0) 1
    else n * factorial(n-1)
  }
  println(factorial(5))

  //3.Fibonacci fnctn
  def fibonacci(n : Int): Int ={
    if ((n==0) || (n==1) || (n==2) ) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }
  println(fibonacci(8))
  //1 1 2 3 5 8 13

  //4.Tets if number is prime
  def checkPrime(n : Int): Boolean = {
    def checkPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && checkPrimeUntil(t-1)
    }
    checkPrimeUntil(n/2)
  }
  println(checkPrime(37))

//  “Isn’t the ‘last action’ a call to itself, making it tail-recursive?”
//
//  If that’s what you’re thinking, fear not, that’s an easy mistake to make. But the answer is no, this function is not tail-recursive. Although sum(tail) is at
  // the end of the second case expression, you have to think like a compiler here, and when you do that you’ll see that the last two actions of this function
  // are:
//
//    1)Call sum(xs)
//    2)When that function call returns, add its value to x and return that result

}
