package com.example.myapplication.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doworld()
}

suspend fun doworld() = coroutineScope {
    // od tuka so launch se deli izvrsuvanjeto na dve nitki
    launch {
        delay(1000)
        println("world")
    }
    println("hello")
}