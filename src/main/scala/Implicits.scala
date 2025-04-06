object Implicits {
  def main(args: Array[String]): Unit = {

    implicit val someAge: Int = 10



    someMethod("Kwame")


  }

  private def someMethod(name: String)(implicit age: Int): Unit = {
    println(s"$name is $age years old")
  }
}
