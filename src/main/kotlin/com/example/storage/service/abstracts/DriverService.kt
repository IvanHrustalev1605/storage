package com.example.storage.service.abstracts

import com.example.storage.entity.Driver
import com.example.storage.entity.Employee

interface DriverService {
    fun createDrivers() : Boolean
    fun findById(id: Long) : Driver
    fun findByLicense(license: String) : Driver
}