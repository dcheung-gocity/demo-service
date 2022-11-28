package com.example.demo.controller

import com.example.demo.dto.DemoRequest
import com.example.demo.dto.DemoResponse
import com.example.demo.service.DemoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(val service: DemoService) {

    @GetMapping(value = ["/test/all"])
    fun getAll(): List<DemoResponse> {
        return service.getAll()
    }

    @GetMapping(value = ["/test"])
    fun get(@RequestParam text: String): DemoResponse? {
        return service.get(text)
    }

    @PostMapping(value = ["/test"])
    fun post(@RequestBody body: DemoRequest): DemoResponse {
        return service.post(body)
    }
}