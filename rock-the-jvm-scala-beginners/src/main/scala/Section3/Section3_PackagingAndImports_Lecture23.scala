package Section3

//suitable package.
import Section2.Section2_ValuesVariablesTypes_Lecture2.{ToBeUsed,ToBeUsedAgain => again}

import java.util.Date
import java.sql.{Date => sqlDate}

object Section3_PackagingAndImports_Lecture23 extends App{

  //packaged members are accessible by their simple name.
  //As soon as we use the class it automatically imports teh suitable package.
  val tobeused = new ToBeUsed

  val tobeusedotehrway = new Section2.Section2_ValuesVariablesTypes_Lecture2.ToBeUsed //FQDN

  //packages are in hierrarchy
  //matching folder structure.

  //package object
  //Section3 is the package object name. Package objects always ends with .scala and mostly contains Macros/Configs. Rarely used though.
  sayHello
  println(SPEED_OF_LIGHT)

  val tobeusedagain = new again
  //We explicitly put the package name 'ToBeUsedAgain' in import statement within curly braces.
  //Or we can use _ for all classes uin the package.
  //Also we gave alias name again to 'ToBeUsedAgain' for naming conflict since a package can have similar classes name

  //1. Use FQDN
  val d = new Date(2018, 5, 11) // Compile will assume this is 1st Date, i.e java.util.date
  val sqldate = new java.sql.Date(2018, 5, 4)


  //2.use aliasing
  val sqlDateAnother = new sqlDate(2018, 5, 4)

  //default imports
  //java.lang - String, Object, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println , ???
}
