package com.example.storage.service.abstracts

import com.example.storage.entity.Driver

interface DriverService {
    fun createDrivers() : Boolean
    fun findById(id: Long) : Driver?
    fun findByLicense(license: String) : Driver
    fun saveDriver(driver: Driver): Boolean
}