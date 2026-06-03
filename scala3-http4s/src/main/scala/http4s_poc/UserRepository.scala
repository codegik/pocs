package http4s_poc

import cats.effect.{Ref, Sync}
import cats.syntax.functor.*

/** In-memory, concurrency-safe user store backed by a [[cats.effect.Ref]]. */
final class UserRepository[F[_]: Sync](
    state: Ref[F, (Map[Long, User], Long)]
):

  def all: F[List[User]] =
    state.get.map(_._1.values.toList.sortBy(_.id))

  def find(id: Long): F[Option[User]] =
    state.get.map(_._1.get(id))

  def create(input: UserInput): F[User] =
    state.modify { case (users, nextId) =>
      val user = User(nextId, input.name, input.email, input.age)
      ((users + (nextId -> user), nextId + 1), user)
    }

  /** Replaces an existing user, preserving its id. Returns None if absent. */
  def update(id: Long, input: UserInput): F[Option[User]] =
    state.modify { case (users, nextId) =>
      users.get(id) match
        case None => ((users, nextId), None)
        case Some(_) =>
          val updated = User(id, input.name, input.email, input.age)
          ((users + (id -> updated), nextId), Some(updated))
    }

  /** Deletes a user, returning true if one was removed. */
  def delete(id: Long): F[Boolean] =
    state.modify { case (users, nextId) =>
      if users.contains(id) then ((users - id, nextId), true)
      else ((users, nextId), false)
    }

  def count: F[Int] =
    state.get.map(_._1.size)

object UserRepository:
  /** Builds an empty repository (ids start at 1). */
  def empty[F[_]: Sync]: F[UserRepository[F]] =
    Ref.of[F, (Map[Long, User], Long)]((Map.empty, 1L)).map(new UserRepository(_))

  /** Builds a repository pre-seeded with the given users (ids reassigned). */
  def seeded[F[_]: Sync](inputs: List[UserInput]): F[UserRepository[F]] =
    val seedMap = inputs.zipWithIndex.map { case (in, idx) =>
      val id = idx + 1L
      id -> User(id, in.name, in.email, in.age)
    }.toMap
    Ref
      .of[F, (Map[Long, User], Long)]((seedMap, seedMap.size + 1L))
      .map(new UserRepository(_))
