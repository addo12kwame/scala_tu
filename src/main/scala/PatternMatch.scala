object PatternMatch extends App {
/*
 * This will be about pattern matching
 *  val variable = object match {
 *      case object(n,a) => f"$n do something with n or do something with $a"
 * }
 */


  val tuple = ("Kwame", "Ama")
  val pat = tuple match


    /*
     * Pattern match with tupe
     */
    case (first, last) => f"$first is a boy and $last is a girl"
  println(pat)

  val patObject = Pers
}

case class Person(name: String, age: Int) {
  def apply(): Unit = {
    println(
      f"""Your name is $name
         |Your age is $age
         |""".stripMargin)
  }

}


