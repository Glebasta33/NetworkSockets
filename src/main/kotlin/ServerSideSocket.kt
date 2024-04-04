package com.github.gltrusov

import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    ServerSocket(8189).use { serverSocket ->
        val socket = serverSocket.accept()

        val writer = PrintWriter(socket.getOutputStream(), true)

        repeat(3) {
            writer.println("hello from server $it")
            Thread.sleep(3000)
        }

    }
}