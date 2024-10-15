import com.codegik.batch.{BatchProcessPipelineConcise, BatchProcessStream}
import zio.stream.{ZSink, ZStream}
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object AppProcessPipelineConcise extends ZIOAppDefault {

  def run: ZIO[ZIOAppArgs & Scope, Any, Any] = {
    for {
      batch <- BatchProcessPipelineConcise("input-data.csv").run
    } yield true
  }
}

