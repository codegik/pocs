package com.codegik.poc.minion

import com.codegik.poc.minion.client.MinionClient

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        MinionClient().start()
    } else {
        when (args.size) {
            1 -> MinionClient(args[0]).start()
            2 -> MinionClient(args[0], args[1].toInt()).start()
        }
    }
}