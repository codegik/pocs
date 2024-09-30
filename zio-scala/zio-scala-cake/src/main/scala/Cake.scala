import zio._

trait Cake

object Cake {
  val layer: ZLayer[Chocolate & Flour, Nothing, Cake] =
    for {
      _ <- ZLayer.environment[Chocolate & Flour]
      cake <- ZLayer.succeed(new Cake {})
    } yield cake
}

trait Spoon

object Spoon {
  val layer: ULayer[Spoon] =
    ZLayer.succeed(new Spoon {})
}

trait Chocolate

object Chocolate {
  val layer: ZLayer[Spoon, Nothing, Chocolate] =
    ZLayer.service[Spoon].project(_ => new Chocolate {})
}

trait Flour

object Flour {
  val layer: ZLayer[Spoon, Nothing, Flour] =
    ZLayer.service[Spoon].project(_ => new Flour {})
}