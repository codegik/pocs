package com.codegik

import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}

object Main extends App {
  implicit val formats: Formats = DefaultFormats

  println("=== Json4S POC ===\n")

  val person = Person("John Doe", 30, "john@example.com")
  val address = Address("123 Main St", "New York", "10001")
  val personWithAddress = PersonWithAddress(person, address)

  println("1. Serialize object to JSON:")
  val json = write(personWithAddress)
  println(json)
  println()

  println("2. Parse JSON string:")
  val parsedJson = parse(json)
  println(pretty(render(parsedJson)))
  println()

  println("3. Deserialize JSON to object:")
  val deserializedPerson = read[PersonWithAddress](json)
  println(s"Person: ${deserializedPerson.person.name}, Age: ${deserializedPerson.person.age}")
  println(s"Address: ${deserializedPerson.address.street}, ${deserializedPerson.address.city}")
  println()

  println("4. Extract specific values:")
  val name = (parsedJson \ "person" \ "name").extractOpt[String]
  val city = (parsedJson \ "address" \ "city").extractOpt[String]
  println(s"Name: ${name.getOrElse("N/A")}")
  println(s"City: ${city.getOrElse("N/A")}")
  println()

  println("5. Manual JSON construction:")
  val manualJson = JObject(
    "title" -> JString("Json4S POC"),
    "version" -> JString("1.0"),
    "features" -> JArray(List(
      JString("parsing"),
      JString("serialization"),
      JString("extraction")
    ))
  )
  println(pretty(render(manualJson)))
}
