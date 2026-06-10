package com.codegik.streaming

import cats.effect.Async
import cats.syntax.semigroupk.*
import org.http4s.HttpApp
import org.http4s.server.middleware.Logger

object Api:

  def routes[F[_]: Async]: HttpApp[F] =
    val combined = EventRoutes[F] <+> NumberRoutes[F]
    Logger.httpApp(logHeaders = true, logBody = false)(combined.orNotFound)
