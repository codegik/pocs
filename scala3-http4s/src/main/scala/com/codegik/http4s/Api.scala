package com.codegik.http4s

import cats.effect.Async
import cats.syntax.semigroupk.* // <+> to combine routes
import org.http4s.HttpApp
import org.http4s.server.middleware.Logger

/** Wires the route modules together into a single [[HttpApp]]. */
object Api:

  def routes[F[_]: Async](repo: UserRepository[F]): HttpApp[F] =
    val combined = HelloRoutes[F] <+> UserRoutes[F](repo)
    // orNotFound turns the partial HttpRoutes into a total HttpApp.
    Logger.httpApp(logHeaders = true, logBody = false)(combined.orNotFound)
