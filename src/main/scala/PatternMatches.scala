object PatternMatches {
  trait Expr

  case class Number(n: Int) extends Expr

  def show(e: Expr) = e match
    case Number(n: Int) => print(n)
    case _ => println("error")

  def main(args:Array[String])= {
  show(Number(3))}
}
