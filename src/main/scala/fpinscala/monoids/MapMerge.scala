package fpinscala.monoids

/*
 * A monoid for merging key-value Maps, as long as the value type is a Monoid.
 */
object MapMerge {
  def mapMergeMonoid[K, V](V: Monoid[V]): Monoid[Map[K, V]] =
    new Monoid[Map[K, V]] {
      override def zero: Map[K, V] =
        Map.empty[K, V]

      override def op(a: Map[K, V], b: Map[K, V]): Map[K, V] =
        (a.keySet ++ b.keySet).foldLeft(zero) { (acc, k) =>
          acc.updated(k, V.op(a.getOrElse(k, V.zero), b.getOrElse(k, V.zero)))
        }
  }
}
