package com.codegik.poc.toxiproxy

import com.mysql.cj.jdbc.MysqlDataSource
import eu.rekawek.toxiproxy.Proxy
import eu.rekawek.toxiproxy.ToxiproxyClient
import eu.rekawek.toxiproxy.model.ToxicDirection.DOWNSTREAM
import java.sql.Connection
import kotlin.system.exitProcess


fun main() {
    var startedAt = System.currentTimeMillis()
    val proxy = mysqlProxy()
    val connection = mysqlConnection()
    connection.createStatement().executeQuery("select 1")
    connection.close()
    println("Without toxic Took ${System.currentTimeMillis() - startedAt}ms")

    proxy.toxics().latency("my-latency-toxic", DOWNSTREAM, 1000).jitter = 15

    startedAt = System.currentTimeMillis()
    val connection2 = mysqlConnection()
    connection2.createStatement().executeQuery("select 1")
    connection2.close()
    println("With toxic Took ${System.currentTimeMillis() - startedAt}ms")

    exitProcess(1)
}

fun mysqlProxy(): Proxy {
    val client = ToxiproxyClient()
    client.proxies.forEach { it.delete() }
    return client.createProxy("mysql", "127.0.0.1:23306", "127.0.0.1:3306")
}

fun mysqlConnection(): Connection {
    val dataSource = MysqlDataSource()
    dataSource.user = "root"
    dataSource.password = "my-secret-pw"
    dataSource.setURL("jdbc:mysql://127.0.0.1:23306")

    return dataSource.connection
}