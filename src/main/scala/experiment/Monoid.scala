package experiment

/**
 * A monoid class.
 *
 * A monoid must contain a type, an operation defined on two elements of that type and a zero element.
 *
 * The operation must have associativity property.
 *
 * @author Emre Çelikten
 * @date   03/07/2015-22:47
 */

trait Monoid[A] {
  def op(a1: A, a2: A): A

  def zero: A
}
