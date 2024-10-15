import com.codegik.batch.BatchProcessStream
import zio.stream.{ZSink, ZStream}
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object AppProcessStream extends ZIOAppDefault {

  private val myApp: ZStream[Any, Throwable, Int] = for {
    batch <- BatchProcessStream("input-data.csv").run
    _ <- ZStream.succeed(4)
  } yield 4

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] = {
    myApp.run(ZSink.count)
  }
}

