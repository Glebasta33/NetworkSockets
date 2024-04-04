package com.github.gltrusov.network

import java.net.InetSocketAddress
import java.net.Socket
import java.util.Scanner

fun main() {
    // Сокет позволяет создать соединение с другим компьютером в сети.
    Socket().use { socket ->
        socket.connect(InetSocketAddress(
            "127.0.0.1", // hostname (доменное имя, ip) - адрес, имя компьютера.
            8189 // port - идентификатор программы, которая будет обрабатывать запрос.
        ), 2000)

        val scanner = Scanner(socket.getInputStream())
        while (scanner.hasNextLine()) {
            println(scanner.nextLine())
        }
    }
}