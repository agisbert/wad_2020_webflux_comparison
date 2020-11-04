package de.porsche.wad2020.webflux

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@SpringBootApplication
class WebfluxApplication

fun main(args: Array<String>) {
    runApplication<WebfluxApplication>(*args)
}

@Configuration
class myWebClientConfig {

    @Bean
    fun myWebClient(webClientBuilder: WebClient.Builder) = webClientBuilder.build()
}

@RestController
class PingController {

    @Autowired
    private lateinit var webClient: WebClient

    @Value("\${ping.host:}")
    private lateinit var pingHost: String

    @GetMapping("ping")
    fun reactivePing(): Mono<String> = webClient
        .get()
        .uri("$pingHost/ping")
        .retrieve()
        .bodyToMono(String::class.java)
}