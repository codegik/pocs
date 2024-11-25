package com.codegik.stream

import com.codegik.service.{DataService, InputData}
import zio.ZIO
import zio.stream.{ZPipeline, ZSink, ZStream}

import java.util.{Date, UUID}

case class BatchResult(
  val id: UUID = UUID.randomUUID(),
  var startedAt: Date = new Date(),
  var endedAt: Date = new Date(),
  var status: String = "CREATED",
  var processed: Long = 0,
  var timeTaken: Long = 0,
)

class BatchProcessStream(val fileName: String, val bufferSize: Int = 1000, val parallel: Int = 10) {
  private val dataService = new DataService()
  private val batchResult = BatchResult();

  def run: ZIO[Any, Throwable, BatchResult] = for {
    _ <- ZIO.succeed(batchResult.startedAt = new Date())
    count <- ZStream.fromResource(fileName)
      .via(ZPipeline.utfDecode)
      .via(ZPipeline.splitLines)
      .mapZIOPar(parallel)(line => ZIO.succeed(line.split(";")))
      .mapZIOPar(parallel)(data => ZIO.succeed(InputData(value = data.head.trim.toInt, name = data.last)))
      .buffer(bufferSize)
      .mapZIOPar(parallel)(data => dataService.insert(data))
      .run(ZSink.count)
  } yield {
    batchResult.processed = count
    batchResult.endedAt = new Date()
    batchResult.timeTaken = batchResult.endedAt.getTime - batchResult.startedAt.getTime
    batchResult.status = "COMPLETED"
    batchResult
  }


  def runBufferChunks: ZIO[Any, Throwable, BatchResult] = for {
    _ <- ZIO.succeed(batchResult.startedAt = new Date())
    count <- ZStream.fromResource(fileName)
      .via(ZPipeline.utfDecode)
      .via(ZPipeline.splitLines)
      .mapZIOPar(parallel)(line => ZIO.succeed(line.split(";")))
      .mapZIOPar(parallel)(data => ZIO.succeed(InputData(value = data.head.trim.toInt, name = data.last)))
      .bufferChunks(bufferSize)
      .mapZIOPar(parallel)(data => dataService.insert(data))
      .run(ZSink.count)
  } yield {
    batchResult.processed = count
    batchResult.endedAt = new Date()
    batchResult.timeTaken = batchResult.endedAt.getTime - batchResult.startedAt.getTime
    batchResult.status = "COMPLETED"
    batchResult
  }



  def runWithoutBuffer: ZIO[Any, Throwable, BatchResult] = for {
    _ <- ZIO.succeed(batchResult.startedAt = new Date())
    count <- ZStream.fromResource(fileName)
      .via(ZPipeline.utfDecode)
      .via(ZPipeline.splitLines)
      .mapZIOPar(parallel)(line => ZIO.succeed(line.split(";")))
      .mapZIOPar(parallel)(data => ZIO.succeed(InputData(value = data.head.trim.toInt, name = data.last)))
      .mapZIOPar(parallel)(data => dataService.insert(data))
      .run(ZSink.count)
  } yield {
    batchResult.processed = count
    batchResult.endedAt = new Date()
    batchResult.timeTaken = batchResult.endedAt.getTime - batchResult.startedAt.getTime
    batchResult.status = "COMPLETED"
    batchResult
  }
}