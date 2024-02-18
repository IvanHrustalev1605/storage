package com.example.storage.repository;

import com.example.storage.entity.Driver
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface DriverRepository : JpaRepository<Driver, Long> {

    fun findByLicenseNumber(licenseNumber: String) : Optional<Driver>
}