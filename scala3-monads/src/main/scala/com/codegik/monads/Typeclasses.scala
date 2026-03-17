package com.codegik.monads

// Core typeclasses

/** Functor: any type F[_] that supports mapping over its value. */
trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

/** Apply: a Functor that can apply a wrapped function to a wrapped value. */
trait Apply[F[_]] extends Functor[F] {
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
}

/** Monad: a Functor that also supports sequencing with flatMap and lifting
  * pure values. Defines the fundamental unit of effectful computation.
  */
trait Monad[F[_]] extends Functor[F] {
  def pure[A](a: A): F[A]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  override def map[A, B](fa: F[A])(f: A => B): F[B] =
    flatMap(fa)(a => pure(f(a)))
}

object Monad {
  def apply[F[_]](using M: Monad[F]): Monad[F] = M
}

/** Monoid: an associative binary operation with an identity element.
  * Used by Writer to accumulate logs.
  */
trait Monoid[A] {
  def empty: A
  def combine(x: A, y: A): A
}

object Monoid {
  def apply[A](using M: Monoid[A]): Monoid[A] = M

  given Monoid[String] with {
    def empty: String = ""
    def combine(x: String, y: String): String = x + y
  }

  given listMonoid[A]: Monoid[List[A]] with {
    def empty: List[A] = Nil
    def combine(x: List[A], y: List[A]): List[A] = x ++ y
  }
}

// Identity monad — useful as a target for pure (effect-free) interpretation
type Id[A] = A

given Monad[Id] with {
  def pure[A](a: A): Id[A]                           = a
  def flatMap[A, B](fa: Id[A])(f: A => Id[B]): Id[B] = f(fa)
}
