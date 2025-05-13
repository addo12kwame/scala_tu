object ExprTest:
  def main(args:Array[String]): Unit =
    val num = Number(10)
    val sum = Sum(Number(10),Number(12))
    val exPro = Product(sum, Var("x"))
    println(exPro.show)


