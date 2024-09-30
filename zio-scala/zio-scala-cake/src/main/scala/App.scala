import zio.*

import java.io.IOException

object App extends ZIOAppDefault {

  private val myApp: ZIO[Cake, IOException, Unit] = for {
    cake <- ZIO.service[Cake]
    _ <- Console.printLine(s"Yay! I baked a cake with flour and chocolate: $cake")
  } yield ()

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] =
    myApp.provide(
      Cake.layer,
      Chocolate.layer,
      Flour.layer,
      Spoon.layer,
      ZLayer.Debug.tree
    )
}

