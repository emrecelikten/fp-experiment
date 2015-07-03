package experiment

import org.scalacheck.{Arbitrary, Prop}
import org.scalatest.FlatSpec
import org.scalatest.prop.Checkers

/**
 * A template test class that checks if given monoid homomorphism is satisfied for given monoids.
 * @author Emre Çelikten
 * @date   03/07/2015-23:47
 */
abstract class MonoidHomomorphismAutoSpec[A: Arbitrary, B: Arbitrary] extends FlatSpec with Checkers {
  val monoidA: Monoid[A]
  val monoidB: Monoid[B]
  val h: A => B // Homomorphism

  val name: String

  name should "satisfy homomorphism property" in {
    check(Prop.forAll {
      (a1: A, a2: A) =>
        h(monoidA.op(a1, a2)) == monoidB.op(h(a1), h(a2))
    })
  }

}
