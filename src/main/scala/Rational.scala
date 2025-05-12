import scala.annotation.tailrec

class Rational(n : Int, d: Int) {
  /*
   * This is a check the parameter with require(boolean)
   */
  require(d != 0)
  
  private val g:Int = gcd(n.abs,d.abs)
  
  val numer: Int = n/g
  val denom: Int = d/g

  /*
   * Overriding the toString to return a meaningful message
   */
  override def toString: String = s"$numer/$denom"

  /*
   * Auxiliary constructor or a second constructor which calls the primary constructor and passing 1 as the second argument
   * Everything in the body that isn't a field or a method of the class runs as the primary constructor
   * NB: Auxiliary calls the primary constructor one way or the other
   */
  def this(n:Int) = this(n,1)


  def +(other: Rational): Rational =
    new Rational(
      numer * other.denom + other.numer * denom,
      denom * other.denom
    )

  def *(other: Rational): Rational =
    new Rational(numer * other.numer, denom * other.denom)

  def lessThan(other:Rational): Boolean =
    this.numer * other.denom < this.denom * other.numer

  def max(other: Rational): Rational =
    if this.lessThan(other) then other else this

  
  private def gcd(a: Int, b:Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
