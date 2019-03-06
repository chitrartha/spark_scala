package Section4

object Section4_HOF_And_Curries_Lecture38 extends App {

  //val superFunction: (Int, (String, (Int, Boolean) => Int)) => (Int => Int) = ???
  //The return type of this value is (Int => Int) and it takes input as (Int, Function)
  //We know that whenever the input/output of a function is anothe rfunction is called HOF.
  //val adder: ((Int, Int) => Int) = (a: Int, b: Int) =>  a + b

  //Higher Order Fucntion

  //map, flatMap, filter in MyList all are HOF.

  //function that applies a function n times over a given value x
  //nTimes(f, n, x)
  //nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x))

  def nTimes(f:Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  }

  val plusOne: (Int => Int) = (x: Int) => x + 1
  plusOne(10)
  println(nTimes(plusOne, 10, 1))

  //ntb(f,n) = x => f(f(f(f...f(x))))
  //increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  //val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) ={
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  }
  /*
  Way of thinking:
  1.A function f(f(f(x)) can be thought as f(f(f (x)) so like 3 times function [f(f(f..] applied to something can be thought as lambda. IN this case lambda would be
  f(f(f..)))
  2.So we construct a function which takes a int and this function [f(f(f..)))] applies to our constructed function to give int. In other words it takes
  a Int and applies function [f(f(f..)))] to get Int. SO return type of this constructed function would be (Int => Int)
  3.The output of this function should match (Int => Int).
   */

  val plus10 = nTimesBetter(x => x + 1, 10)
  println(plus10(1))

  //curried functions
  val superAdd: Int => (Int => Int)  = (x: Int) => (y: Int) => x + y
  val add3 = superAdd(3) //y => 3 + y
  println(add3(10))
  println(superAdd(2)(3))


  //function with multiple parameters
  def curriedFormatter(c: String)(x: Double) = c.format(x)
  val standardFormat: (Double => String) = curriedFormatter("%4.2f") //The return type is (Double => String) because we have passed String to curriedFormatter
  //So next parameter it is expecting is double and the curriedFormatter will give String as result.
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  curriedFormatter("%10.8f")(Math.PI)

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))
  println("%4.2f".format(Math.PI))

  def superadder(a: Int)(b: Int): Int = a + b
  println(superadder(5)(9))

  /*
  1. Expand Mylist
    -foreach method A => Unit
    [1,2,3].foreach(println(x))

    -sort function ((A,A) => Int) => MyList
    [1,2,3].sort((x,y) => y - x) => [3,2,1]


    -zipWith (list, (A,B) =>  C) => MyList[C]
    [1,2,3].zipWith([4,5,6], x * y) => [4, 10 , 18]

    -fold(start)(function) => a value
    [1,2,3].fold(0)(x + y) = 6

    //Refer Lecture 39

   2.toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
     fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

   3.compose(f,g) => x => f(g(x))
     andThen(f,g) => x => g(f(x))
   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) ={
    x => y => f(x,y)
  }

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int ={
    (x, y) => f(x)(y)
  }

  def compose[A,B,T](f: A => B, g: T => A): T => B ={
    x => f(g(x))
  }

  def andThen[A,B,C](f: A => B, g: B => C): A => C ={
    x => g(f(x))
  }

  def superAdder2 = toCurry(_ + _)
  //def superAdder3 = toCurry((x: Int, y: Int) => x + y)   same as above
  def add4 = superAdder2(4)
  println(add4(7))

  val simpleAdder = fromCurry(superAdder2)
  //val simpleAdder2 = fromCurry((x: Int) => (y: Int) => x + y)   same as above
  println(simpleAdder(4,7))
  //println(simpleAdder2(4,7))

  val add2 = (x:Int) => x + 2
  val times3 = (x:Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))






}
