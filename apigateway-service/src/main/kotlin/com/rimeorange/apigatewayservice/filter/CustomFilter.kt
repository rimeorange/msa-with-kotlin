package com.rimeorange.apigatewayservice.filter

import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


private val log = KotlinLogging.logger {}

@Component
class CustomFilter : AbstractGatewayFilterFactory<CustomFilter.Config>(Config::class.java) {

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter {
            exchange, chain ->
                val request: ServerHttpRequest = exchange.request
                val response: ServerHttpResponse = exchange.response

                log.info("Custom PRE filter: request id -> {} ", request.id)

                chain.filter(exchange).then(
                    Mono.fromRunnable {
                        log.info("Custom POST filter: response code -> {}", response.statusCode)
                    }
                )
        }
    }

    class Config {}
}