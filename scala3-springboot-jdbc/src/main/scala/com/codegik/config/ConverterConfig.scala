package com.codegik.config

import com.codegik.domain.model.{AdminRole, DevRole, Role, TesterRole}
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.{ReadingConverter, WritingConverter}
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration

import scala.jdk.CollectionConverters.*

@ReadingConverter
class RoleReadConverter extends Converter[String, Role] {
  override def convert(source: String): Role = {
    source match {
      case "admin" => new AdminRole {}
      case "tester" => new TesterRole {}
      case "dev" => new DevRole {}
      case _ => throw new IllegalArgumentException(s"Unknown role: $source")
    }
  }
}

@WritingConverter
class RoleWriteConverter extends Converter[Role, String] {
  override def convert(role: Role): String = {
    role match {
      case _: AdminRole => "admin"
      case _: TesterRole => "tester"
      case _: DevRole => "dev"
      case _ => throw new IllegalArgumentException(s"Unknown role: $role")
    }
  }
}

@Configuration
class MyJdbcConfiguration extends AbstractJdbcConfiguration {

  override def userConverters(): java.util.List[Any] = {
    List(new RoleWriteConverter(), new RoleReadConverter()).asJava
  }

}