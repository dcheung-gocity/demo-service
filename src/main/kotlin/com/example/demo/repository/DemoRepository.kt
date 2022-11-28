package com.example.demo.repository

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface DemoRepository : MongoRepository<Demo, Int> {
    fun findByText(text: String): Demo?
}