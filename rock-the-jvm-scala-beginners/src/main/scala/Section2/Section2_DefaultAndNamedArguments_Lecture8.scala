package Section2

import scala.annotation.tailrec


object Section2_DefaultAndNamedArguments_Lecture8 extends App{

  @tailrec
  def factTailrec(x: Int, accumulator: Int = 1): Int =
    if (x <= 1) accumulator
    else factTailrec(x-1, x * accumulator) // Tail recursive functino always have last expression as recursion.

  println(factTailrec(5))

  //Either keep the default Agrument at the most right
  //Or if there are more than one defulat args than name the arguments while passing..Else the compiler will get confused which Args value is this.

  def saveThepicture(format: String = "JPG", height: Int = 10, width: Int = 10 ): Unit = println("Save Picture")
  println(saveThepicture("BMP", 800, 800))

}

