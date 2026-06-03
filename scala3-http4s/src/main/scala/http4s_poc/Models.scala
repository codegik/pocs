package http4s_poc

import cats.effect.Concurrent
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.circe.{jsonEncoderOf, jsonOf}

/** A user persisted by the service. */
final case class User(id: Long, name: String, email: String, age: Int)

object User:
  given Encoder[User] = deriveEncoder
  given Decoder[User] = deriveDecoder

  given [F[_]]: EntityEncoder[F, User]       = jsonEncoderOf
  given [F[_]]: EntityEncoder[F, List[User]] = jsonEncoderOf
  given [F[_]: Concurrent]: EntityDecoder[F, User]       = jsonOf
  given [F[_]: Concurrent]: EntityDecoder[F, List[User]] = jsonOf

/** Payload used to create or replace a user (no id, server-assigned). */
final case class UserInput(name: String, email: String, age: Int):
  /** Basic domain validation; returns the list of problems (empty == valid). */
  def validate: List[String] =
    List(
      Option.when(name.trim.isEmpty)("name must not be blank"),
      Option.when(!email.contains("@"))("email must be a valid address"),
      Option.when(age < 0 || age > 150)("age must be between 0 and 150"),
    ).flatten

object UserInput:
  given Encoder[UserInput] = deriveEncoder
  given Decoder[UserInput] = deriveDecoder

  given [F[_]]: EntityEncoder[F, UserInput]        = jsonEncoderOf
  given [F[_]: Concurrent]: EntityDecoder[F, UserInput] = jsonOf

/** Standard error envelope returned to clients. */
final case class ApiError(errors: List[String])

object ApiError:
  def apply(error: String): ApiError = ApiError(List(error))

  given Encoder[ApiError] = deriveEncoder
  given Decoder[ApiError] = deriveDecoder

  given [F[_]]: EntityEncoder[F, ApiError]        = jsonEncoderOf
  given [F[_]: Concurrent]: EntityDecoder[F, ApiError] = jsonOf
