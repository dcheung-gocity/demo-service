package com.example.demo.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import java.util.UUID

data class Demo(
    @Id
    val id: UUID,
    @Indexed(unique = true)
    val text: String
)