package com.rimeorange.secondservice

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger {}

@RestController
@RequestMapping("/second-service")
class SecondServiceController {

    @GetMapping("/welcome")
    fun welcome(): String {
        return "Welcome to Second Service!"
    }

    @GetMapping("/message")
    fun message(@RequestHeader("first-request") header: String): String{
        log.info(header)
        return "Hello World to Second Service!"
    }
}