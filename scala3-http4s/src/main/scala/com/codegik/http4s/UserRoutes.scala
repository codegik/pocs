package com.codegik.http4s

import cats.effect.Concurrent
import cats.syntax.flatMap.*
import cats.syntax.functor.*
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

/** REST CRUD routes for [[User]], mounted under `/users`. */
object UserRoutes:

  def apply[F[_]: Concurrent](repo: UserRepository[F]): HttpRoutes[F] =
    val dsl = Http4sDsl[F]
    import dsl.*

    HttpRoutes.of[F] {
      // GET /users -> list all users
      case GET -> Root / "users" =>
        repo.all.flatMap(Ok(_))

      // GET /users/:id -> single user or 404
      case GET -> Root / "users" / LongVar(id) =>
        repo.find(id).flatMap {
          case Some(user) => Ok(user)
          case None       => NotFound(ApiError(s"user $id not found"))
        }

      // POST /users -> create, with body decoding + validation
      case req @ POST -> Root / "users" =>
        req.attemptAs[UserInput].value.flatMap {
          case Left(failure) => BadRequest(ApiError(failure.message))
          case Right(input) =>
            input.validate match
              case Nil    => repo.create(input).flatMap(Created(_))
              case errors => BadRequest(ApiError(errors))
        }

      // PUT /users/:id -> replace an existing user
      case req @ PUT -> Root / "users" / LongVar(id) =>
        req.attemptAs[UserInput].value.flatMap {
          case Left(failure) => BadRequest(ApiError(failure.message))
          case Right(input) =>
            input.validate match
              case errors @ (_ :: _) => BadRequest(ApiError(errors))
              case Nil =>
                repo.update(id, input).flatMap {
                  case Some(user) => Ok(user)
                  case None       => NotFound(ApiError(s"user $id not found"))
                }
        }

      // DELETE /users/:id -> remove, 204 on success
      case DELETE -> Root / "users" / LongVar(id) =>
        repo.delete(id).flatMap {
          case true  => NoContent()
          case false => NotFound(ApiError(s"user $id not found"))
        }
    }
