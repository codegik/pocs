package com.codegik.zioapp
package implementation
package kafka

final case class KafkaConfig(bootstrapServers: List[String], eventTopic: String)
