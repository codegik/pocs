import com.codegik.batch.BatchProcessPipeline
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object AppProcessPipeline extends ZIOAppDefault {

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] = {
    for {
      batch <- BatchProcessPipeline("input-data.csv").run
    } yield true
  }
}

