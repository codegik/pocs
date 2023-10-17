package com.codegik.poc.minion

import com.codegik.poc.minion.client.MinionClient

fun main(args: Array<String>) {
    MinionClient("localhost").start()
}