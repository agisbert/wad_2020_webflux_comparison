package de.porsche.wad.mvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class MvcApplication

fun main(args: Array<String>) {
	runApplication<MvcApplication>(*args)
}

@Configuration
class myRestTemplateConfig {
	@Bean
	fun myRestTemplate(restTemplateBuilder: RestTemplateBuilder) = restTemplateBuilder.build()
	val aux = PingController()
}

@RestController
class PingController {

	@Autowired
	private lateinit var restTemplate: RestTemplate

	@Value("\${ping.host:}")
	private lateinit var pingHost: String

	@GetMapping("ping")
	fun blockingPing() : String? = restTemplate
		.getForEntity("$pingHost/ping", String::class.java)
		.body
}
