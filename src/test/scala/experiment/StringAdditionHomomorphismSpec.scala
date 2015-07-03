package experiment

/**
 * @author Emre Çelikten
 * @date   03/07/2015-23:52
 */
class StringAdditionHomomorphismSpec extends {
  override val monoidA: Monoid[String] = new Monoid[String] {
    override def op(a1: String, a2: String): String = a1 + a2

    override def zero: String = ""
  }

  override val monoidB: Monoid[Int] = new Monoid[Int] {
    override def op(a1: Int, a2: Int): Int = a1 + a2

    override def zero: Int = 0
  }

  override val h: (String) => Int = _.length

  override val name: String = "String length homomorphism"

} with MonoidHomomorphismAutoSpec[String, Int]