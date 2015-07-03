package experiment

import org.scalacheck.{Arbitrary, Prop}
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.prop.Checkers

/**
 * A template test class that can be used to check if concrete instances of monoids satisfy monoid properties.
 * @author Emre Çelikten
 * @date   03/07/2015-22:59
 */
abstract class MonoidSpec[T : Arbitrary] extends FlatSpec with Checkers with Matchers {
  val monoid: Monoid[T]
  val name: String

  name should "satisfy zero propety" in {
    check(Prop.forAll {
      (t1: T) =>
        monoid.op(t1, monoid.zero) == t1
        monoid.op(monoid.zero, t1) == t1
    })
  }

  it should "satisfy associativity property" in {
    check(Prop.forAll((t1: T, t2: T, t3: T) => monoid.op(monoid.op(t1, t2), t3) == monoid.op(t1, monoid.op(t2, t3))))
  }


}
