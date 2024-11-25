import com.codegik.service.DataService
import com.codegik.stream.{BatchProcessStream, BatchResult}
import zio.*
import zio.Console.printLine

object App extends ZIOAppDefault {
  private val fileName = "input-data-10k.csv"

  private val runWithoutBuffer: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName).runWithoutBuffer
    _ <- printLine(s"runWithoutBuffer: $batch")
  } yield batch

  private val runWithBuffer100: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 100).run
    _ <- printLine(s"runWithBuffer100: $batch")
  } yield batch

  private val runWithBuffer1000: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 1000).run
    _ <- printLine(s"runWithBuffer1000: $batch")
  } yield batch

  private val runWithBuffer5000: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 5000).run
    _ <- printLine(s"runWithBuffer5000: $batch")
  } yield batch

  private val runWithBufferChunk1000: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 1000).runBufferChunks
    _ <- printLine(s"runWithBufferChunk1000: $batch")
  } yield batch

  private val runWithBufferChunk100: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 100).runBufferChunks
    _ <- printLine(s"runWithBufferChunk100: $batch")
  } yield batch

  private val runWithBufferChunk500: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 500).runBufferChunks
    _ <- printLine(s"runWithBufferChunk500: $batch")
  } yield batch

  private val runWithBufferChunk5000: ZIO[Any, Throwable, BatchResult] = for {
    batch <- BatchProcessStream(fileName, 5000).runBufferChunks
    _ <- printLine(s"runWithBufferChunk5000: $batch")
  } yield batch

  def run: ZIO[ZIOAppArgs & Scope, Throwable, Boolean] = for {
    _ <- runWithoutBuffer
    _ <- runWithBuffer100
    _ <- runWithBuffer1000
    _ <- runWithBuffer5000
    _ <- runWithBufferChunk100
    _ <- runWithBufferChunk500
    _ <- runWithBufferChunk1000
    _ <- runWithBufferChunk5000
  } yield true
}
