package com.codegik.batch

import com.codegik.domain.InputData
import zio.Console.printLine
import zio.ZIO
import zio.stream.{ZPipeline, ZSink, ZStream}

import java.io.IOException

class BatchProcessPipeline(val fileName: String) {

  def run: ZIO[Any, Throwable, Long] = {
    val byteStream: ZStream[Any, Throwable, Byte] = ZStream.fromResource(fileName)

    val stringStream: ZStream[Any, Throwable, String] =
      byteStream >>> ZPipeline.utfDecode >>> ZPipeline.splitLines

    val transformPipeline: ZPipeline[Any, IOException, String, InputData] =
      ZPipeline
        .map(line => line.toString.split(";"))
        .map(data => InputData(id = data.head.toInt, name = data.last))
        .tap(data => printLine(s"Persisting ${data.id}"))

    val sinkResult = ZSink.count

    val result: ZIO[Any, Throwable, Long] =
      stringStream >>> transformPipeline >>> sinkResult

    result
  }

}