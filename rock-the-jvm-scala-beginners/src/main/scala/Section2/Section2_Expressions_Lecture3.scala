package Section2

object Section2_Expressions_Lecture3 extends App {

  //Expressions
  val x = 1+2
  println(x)
  // + - * / & | << >> >>>

  println(1==x)
  // == != < > >= <=

  println(!(x==1))
  // ! && ||

  var aVaribale = 2
  aVaribale += 3 // Also works with + -= *= /= This all are side affects.

  //Instructions(DO) vs Expressions(VALUE)
  // If Expression
  val aCondition = true
  val aConditionalue = if(aCondition) 5 else 3 //Expression
  println(aConditionalue)

  var i = 0
  val aWhile = while (i < 10){
    println(i)
    i+=10
  }

  //Never write this again
  //Everything in scala is expression!

  val aweirdValue = (aVaribale = 3)
  //See here the type of aweirdValue is Unit.
  println(aweirdValue)
  //Prints ()

  // Side effects are println(), reassigning, whiles. If the expression return type is Unit then it has side effects.

  //Code Blocks
  val aCodeblock = {
    val y = 2
    val z = y + 1
    if (z >2 ) "hello" else "goodbye"
  }
  //Code block is an expression. The value of codeblock is the value of last expression. IN the above its String. Scope of vraible remains in codeblock.

  //1.Difference eb/w String "Hello world" and println("Hello world")
  //String one has return type String BUt println has return type Unit.

  //2.
  val someValue={
    2 < 3
  }

  val someOtherVlaue={
    if (someValue) 239 else 986
    42
  }
  //The o/p will be 42 as thats the last expression.

}
