package Section4

object Section4_Map_FlatMap_Filter_ForComprehension_Lecture40 extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))
  //List(1, 2, 2, 3, 3, 4)

  //print all possible combination between the 2 lists
  //List(a1, a2...d4)
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b' , 'c' , 'd')
  val colors = List("black", "white")


  // "iterating"
  val combinations = numbers.flatMap(n => chars.map(c => " " + c + n))
  //List( a1,  b1,  c1,  d1,  a2,  b2,  c2,  d2,  a3,  b3,  c3,  d3,  a4,  b4,  c4,  d4)
  val combinations2 = numbers.map(n => chars.map(c => " " + c + n))
  //List(List( a1,  b1,  c1,  d1), List( a2,  b2,  c2,  d2), List( a3,  b3,  c3,  d3), List( a4,  b4,  c4,  d4))
  //val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map( clr => " " + c + n + clr)))
  //List( a1black,  a1white,  b1black,  b1white,  c1black,  c1white,  d1black,  d1white,  a2black,  a2white,  b2black,  b2white,  c2black,  c2white,  d2black,  d2white,  a3black,  a3white,  b3black,  b3white,  c3black,  c3white,  d3black,  d3white,  a4black,  a4white,  b4black,  b4white,  c4black,  c4white,  d4black,  d4white)
  println(combinations)
  println(combinations2)

  //foreach
  list.foreach(println)

  //for comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // numbers.filter(_ % 2 == 0).flatMap..
    c <- chars
    clr <- colors
  } yield " " + c + n + clr
  println(forCombinations)

  //for comprehension with side effects.
  for {
    n <- numbers
  } println(n)
  //equivalent to foreach(println)

  //syntax overload
  list.map ( x =>
    x * 2
  )

  /*
  1. MyList supports for comprehensions?
  map(f: A => B): MyList[A]
  filter(p: A => Boolean): MyList[A]
  flatMap(f: A => MyList[B]): MyList[B]

  Since for this methods must be defined for "for comprehensions" our MyList supports this[Line 22-24 of Section4_Funtcion_Lecture40_MyList.scala]
  ex. of for comprehension on [Line 192-198 of Section4_Funtcion_Lecture40_MyList.scala]


  2. A small collection of at most ONE element - maybe[+T]
  Refer Section4_Maybe_Lecture40.scala
  
   */

}
