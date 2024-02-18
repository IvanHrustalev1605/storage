package com.example.storage.entity

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.time.LocalDateTime

@Embeddable
open class PersonInfo : Serializable {
    open var login: String? = null
    open var firstName: String? = null
    open var middleName: String? = null
    open var secondName: String? = null
    open var email: String? = null
    open var dopInfo: String? = null
    open var age: Int? = null
    open var createdAt: LocalDateTime? = null
    open var updatedAt: LocalDateTime? = null
}