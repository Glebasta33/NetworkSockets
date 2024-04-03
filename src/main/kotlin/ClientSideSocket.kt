package com.github.gltrusov

import java.net.InetSocketAddress
import java.net.Socket
import java.util.Scanner

fun main() {
    Socket().use { socket ->
        socket.connect(InetSocketAddress("india.colorado.edu", 13), 2000)

        val scanner = Scanner(socket.getInputStream())
        while (scanner.hasNextLine()) {
            println(scanner.nextLine())
        }
    }
}