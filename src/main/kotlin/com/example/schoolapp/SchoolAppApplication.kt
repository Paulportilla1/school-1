package com.example.schoolapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SchoolAppApplication

fun main(args: Array<String>) {
	runApplication<SchoolAppApplication>(*args)
}
