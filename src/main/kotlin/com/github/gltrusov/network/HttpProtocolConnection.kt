package com.github.gltrusov.network

import java.net.URL
import java.net.URLConnection
import java.util.Scanner

/**
 * На чистых сокетах не получится подключиться к большинству серверов, тк они используют протоколы - более высокоуровневые надстройки над сокетами.
 * URLConnection - это надстройка над сокетами, которая позволяет создать connection по http протоколу.
 */
fun main() {
    val urlConnection: URLConnection = URL("http://www.google.com/").openConnection()

    val scanner = Scanner(urlConnection.getInputStream())

    while (scanner.hasNextLine()) {
        println(scanner.nextLine())
    }

    urlConnection.headerFields.forEach { t, u ->
        println("Header: $t | $u")
    }

}