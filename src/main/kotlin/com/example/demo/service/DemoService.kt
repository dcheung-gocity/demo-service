package com.example.demo.service

import com.example.demo.dto.DemoRequest
import com.example.demo.dto.DemoResponse
import com.example.demo.repository.Demo
import com.example.demo.repository.DemoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID.randomUUID

@Service
class DemoService(val repository: DemoRepository) {

    fun getAll(): List<DemoResponse> {
        return repository.findAll().asIterable().map { DemoResponse(it.id, it.text) }
    }

    fun get(text: String): DemoResponse? {
        val demo = repository.findByText(text) ?: return null
        return DemoResponse(demo.id, demo.text)
    }

    @Transactional
    fun post(body: DemoRequest): DemoResponse {
        val demo = Demo(randomUUID(), body.text)
        repository.save(demo)
        return DemoResponse(demo.id, demo.text)
    }
}