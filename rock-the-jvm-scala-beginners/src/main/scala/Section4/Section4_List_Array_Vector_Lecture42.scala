package Section4

import scala.util.Random

object Section4_List_Array_Vector_Lecture42 extends App{

  //Seq
  val aSequence = Seq(2,3,1)
  //sequence is actually a list.
  //So the Seq companion object actually has an apply factory method that can construct subclasses of sequence.
  //But the declared type of a sequence is sequence of int.
  println(aSequence) //type is Seq[Int]
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,6,5))
  println(aSequence.sorted)
  //List(2, 3, 1)
  //List(1, 3, 2)
  //1
  //List(2, 3, 1, 7, 6, 5)
  //List(1, 2, 3)


  //Ranges
  val aRange: Seq[Int] = 1 to 10 // OR, 1 until 10  //if we need to inclusive.
  aRange.foreach(println)

  (1 to 10 ).foreach(println)

  //lists
  val aList = List(1,2,3)
  val prepended = 42 :: aList // or we can use +: ..for appendin :+
  println(prepended)
  //List(42, 1, 2, 3)


  val apples5 = List.fill(5)("apple")
  println(apples5)
  //List(apple, apple, apple, apple, apple)
  println(aList.mkString("-|-"))
  //1-|-2-|-3

  //arays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  threeElements.foreach(println)

  //List are immutable and Arrays are mutable.

  //mutation
  numbers(2) = 0 //syntax suar for numbers.update(2, 0)
  println(numbers)
  //[I@5ebec15
  println(numbers.mkString(" "))
  //1 2 0 4

  //arrays and seq
  val numberSeq: Seq[Int] = numbers //implicit conversions
  println(numberSeq)
  //WrappedArray(1, 2, 0, 4)

  //Arrays object only prints reference address whereas seq prints the object

  //vectors
  val vector = Vector(1,2,3)
  println(vector)

  //vectors vs list
  val maxRuns = 1000
  val maxCapacity = 100000

  def getWriteTime(collections: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collections.updated(r.nextInt(maxCapacity),0)
      System.nanoTime() - currentTime
    }

    times.sum / maxRuns

  }

  //keeps refernce to tail
  //updating an element at teh middle takes long
  val numbersList = (1 to maxCapacity).toList

  //depth of the tree is small
  //needs to replace an entire 32-element chunk
  val numbersVector= (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))

  //vector is defualt implementation of Seq.




}
