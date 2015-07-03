package experiment

import org.scalatest.FlatSpec
import org.scalatest.prop.Checkers

/**
 * Just a meaningless test class to make sure that the test environment works.
 *
 * @author Emre Çelikten
 * @date   03/07/2015-22:54
 */
class IntAdditionMonoidAutoSpec extends {
  override val monoid: Monoid[Int] = new Monoid[Int] {
    override def op(a1: Int, a2: Int): Int = a1 + a2

    override def zero: Int = 0
  }

  override val name: String = "IntAdditionMonoid"
} with MonoidAutoSpec[Int]