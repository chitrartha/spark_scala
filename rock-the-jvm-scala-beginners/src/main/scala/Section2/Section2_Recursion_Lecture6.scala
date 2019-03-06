package Section2

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Section2_Recursion_Lecture6 extends App{

  def factorial(n : Int): Int ={
    if (n == 0) 1
    else {
      println("Computing fcatorial of " + n + " - I first need the factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed fcatorial of " + n)
      result
    }
  }
  println(factorial(5))

//  Output:
//  Computing fcatorial of 5 - I first need the factorial of 4
//  Computing fcatorial of 4 - I first need the factorial of 3
//  Computing fcatorial of 3 - I first need the factorial of 2
//  Computing fcatorial of 2 - I first need the factorial of 1
//  Computing fcatorial of 1 - I first need the factorial of 0
//  Computed fcatorial of 1
//  Computed fcatorial of 2
//  Computed fcatorial of 3
//  Computed fcatorial of 4
//  Computed fcatorial of 5
//  120
//  So if the number is large JVM goes StackOverflow error. Thats why tail recursion comes.

  def anotherFactorial(n : Int): Int ={
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) // Tail recursive functino always have last expression as recursion.

    factHelper(n, 1)
  }
  println(anotherFactorial(5))
  //anotherFactorial(5) = factHelper(5,1) = factHelper(4, 5 * 1) = factHelper(3, 4 * 5 * 1)

  //If the output is pretty large int use BigInt else the o/p will be 0 since it cannot accomodate large number with Int.

  //When ever use loop use tail recursion.
  //Always use as many no. of accumulators as the no. of type of recursions. refere below fibonacci series example.
  //Always initiate the Accumulator.
  //Generally the lgic goes in this part: "x * accumulator"
  //The initial condition will contain accumulator, as ex: if (x <= 1) accumulator


  //1.Concatenate string tail recursive
  @tailrec
  def aRepeatedFunctionTailRec(aString : String, n: Int, accumulator: String): String ={
    if (n<=0) accumulator
    else aRepeatedFunctionTailRec(aString, n-1, aString + accumulator)
  }
  println(aRepeatedFunctionTailRec("Hello", 3, ""))


  //2.Find prime number by tail rec
  def checkPrime(n: Int): Boolean ={
    @tailrec
    def checkPrimeHelper(i: Int, checkPrimeValue: Boolean): Boolean={
      if (!checkPrimeValue) false
      else if (i <= 1) true
      else checkPrimeHelper(i-1, i % n !=0 && checkPrimeValue)
    }
    checkPrimeHelper(2, true)
  }
  println(checkPrime(37))


  //3.Write Fibonacci series with tail recursion
  def fibonacci(n : Int): Int ={
    @annotation.tailrec
    def fiboHelper(i : Int, last: Int, nextToLast: Int): Int = {
      if (i > n ) last
      else fiboHelper(i + 1, last + nextToLast , last)
    }

    if (n <= 2 ) 1
    else fiboHelper(3,1,1)
  }
  println(fibonacci(3))

  /*
0 1 1 2 3 5 8 13

F(0) 0
F(1) 1
F(2) 1
F(3) 2
F(4) 3
F(5) 5


F(3) = F(2) + F(1) =  1 + 1 = 2
Initialization is done F(3), 1, 1. Now F(3) should add 1 + 1,which in turn will come from F(2), so F(2) should return a '2' [previousIndexResult + currentIndexResult],
which in turn will be parameter in F(3) [previousIndexResult]. So as soon as i=n then this result can be returned.

fiboHelper(1, 1 , 1)
fiboHelper(2, 1 , 1) => fiboHelper(3, 2 , 1) => fiboHelper(4, 3 , 2) => fiboHelper(5, 5 , 3)

fiboHelper fnctn should be such that it goves o/p for present index and also gives o/p to next index.

fiboHelper( [index], [o/p for present index], [o/p for previous index])

*/

  //Other example beside
  @annotation.tailrec
  def search(donutName: String, donuts: Array[String], index: Int): Option[Boolean] = {
    if(donuts.length == index) {
      None
    } else if(donuts(index) == donutName) {
      Some(true)
    } else {
      val nextIndex = index + 1
      search(donutName, donuts, nextIndex)
    }
  }

  println(search("donut", Array("donut", "Strawberry Donut", "Plain Donut", "Glazed Donut"), 0 ) )

}
