package com.codegik.batch

import com.codegik.domain.InputData
import zio.Console.printLine
import zio.stream.{ZPipeline, ZSink, ZStream}
import zio.{Chunk, ZIO}

import scala.io.Source

class BatchProcessPipelineConcise(val fileName: String) {

  def run: ZIO[Any, Throwable, Long] = {
    ZStream.fromResource(fileName)
      .via(ZPipeline.utfDecode)
      .via(ZPipeline.splitLines)
      .map(line => line.split(";"))
      .map(data => InputData(id = data.head.toInt, name = data.last))
      .tap(data => printLine(s"Persisting ${data.id}"))
      .runCount
  }

}