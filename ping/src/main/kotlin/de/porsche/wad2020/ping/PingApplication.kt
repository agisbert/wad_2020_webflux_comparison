package de.porsche.wad2020.ping

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration

@SpringBootApplication
class pingApplication

fun main(args: Array<String>) {
	runApplication<pingApplication>(*args)
}


@RestController
class PingController {
	@GetMapping("ping")
	fun slowPing() = Mono
		.just("pong")
		.delayElement(Duration.ofSeconds(8))
}
