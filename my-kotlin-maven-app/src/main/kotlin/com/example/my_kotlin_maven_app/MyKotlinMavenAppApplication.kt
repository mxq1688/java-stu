package com.example.my_kotlin_maven_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyKotlinMavenAppApplication

fun main(args: Array<String>) {
	runApplication<MyKotlinMavenAppApplication>(*args)
}
