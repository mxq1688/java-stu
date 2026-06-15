package com.example.my_kotlin_gradle_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyKotlinGradleAppApplication

fun main(args: Array<String>) {
	runApplication<MyKotlinGradleAppApplication>(*args)
}
