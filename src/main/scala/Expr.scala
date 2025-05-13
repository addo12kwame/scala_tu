import sun.jvm.hotspot.HelloWorld.e

trait Expr:
  def eval: Int = this match
    case Number(n) => n
    case Sum(e1,e2) => e1.eval + e2.eval

  def show: String = this match
    case Number(n) => n.toString
    case Sum(e1,e2) => s"${e1.show} + ${e1.show}"
    case Var(name) => name
    case Product(e1, e2) => s"${showWithParan(e1)} * ${showWithParan(e2)}"



case class Number(n:Int) extends Expr
case class Sum(e1:Expr,e2:Expr) extends Expr
case class Var(name: String ) extends Expr
case class Product(e1:Expr,e2:Expr) extends Expr

def showWithParan(e: Expr): String = e match
  case e: Sum => s"(${e.show})"
  case _ => s"${e.show}"