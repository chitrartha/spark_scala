package Section2

object Section2_CallByName_CallByValue_Lecture7 extends App {

  def calledByValue(x: Long): Unit = {

    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {

    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  //ByValue passes the value of System.nanoTime() to x.
  //ByName literally executes the System.nanoTime() everytime. Hence 2 different time for ByName.

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)
  //This gives stackoverflow error, as it tries to calculate infinte() first.

  printFirst(34, infinite())
  //In this it executes fine as infinite() is lazily executed. As infinte() is never used in printFirst().

  //=> Can help in lazy evaluation which is core in Scala.

}
