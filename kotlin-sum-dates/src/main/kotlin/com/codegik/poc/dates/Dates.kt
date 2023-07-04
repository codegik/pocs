package com.codegik.poc.dates

class Dates {

  fun addSeconds(date: String, plusSeconds: Long): String {
    val dateTime  = date.split(" ")

    val sliceDate = dateTime[0].split("-")
    val sliceTime = dateTime[1].split(":")

    val oneMin    = 60
    val oneHour   = 60 * oneMin
    val oneDay    = 24 * oneHour
    val oneMonth  = 30 * oneDay
    val allMonths = 12 * oneMonth
    val oneYear   = 365 * allMonths

    val restSec   = plusSeconds % 60
    val restMin   = (plusSeconds % oneHour) / oneMin
    val restHour  = (plusSeconds % oneDay) / oneHour
    val restDay   = (plusSeconds % oneMonth) / oneDay
    val restMonth = (plusSeconds % allMonths) / oneMonth
    val restYear  = (plusSeconds % oneYear) / allMonths

    val sec       = sliceTime[2].toInt() + restSec
    val min       = sliceTime[1].toInt() + restMin
    val hour      = sliceTime[0].toInt() + restHour
    val day       = sliceDate[2].toInt() + restDay
    val month     = sliceDate[1].toInt() + restMonth
    val year      = sliceDate[0].toInt() + restYear

    return  "$year".padStart(4, '0')  + "-" +
            "$month".padStart(2, '0') + "-" + 
            "$day".padStart(2, '0')   + " " + 
            "$hour".padStart(2, '0')  + ":" +
            "$min".padStart(2, '0')   + ":" +
            "$sec".padStart(2, '0')
  }

}
