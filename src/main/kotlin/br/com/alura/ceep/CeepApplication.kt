package br.com.alura.ceep

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CeepApplication

fun main(args: Array<String>) {
	runApplication<CeepApplication>(*args)
}
