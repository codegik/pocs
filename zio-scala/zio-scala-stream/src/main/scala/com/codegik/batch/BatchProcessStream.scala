package com.codegik.batch

import zio.ZIO
import zio.stream.ZStream

import scala.io.Source

class BatchProcessStream(val fileName: String) {

  private val fileInputStream: ZStream[Any, Throwable, String] = {
    ZStream.fromIterator(Source.fromResource(fileName).getLines())
  }

  private def read: ZStream[Any, Throwable, String] = {
    fileInputStream.takeWhile(_ != null)
  }

  private def process(i: String): ZIO[Any, Throwable, String] = {
    println(s"Processing '$i'")
    ZIO.succeed(i)
  }

  private def persist(i: String): ZIO[Any, Throwable, String] = {
    println(s"Persisting '$i'")
    ZIO.succeed(i)
  }


  def run: ZStream[Any, Throwable, String] = {
    read
      .buffer(1000)
      .mapZIO(process)
      .buffer(1000)
      .tap(persist)
  }

}