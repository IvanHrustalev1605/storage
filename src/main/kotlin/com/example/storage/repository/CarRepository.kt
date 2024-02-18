package com.example.storage.repository;

import com.example.storage.entity.Car
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CarRepository : JpaRepository<Car, Long> {
    fun findByVinNumber(vinNumber: String) : Optional<Car>
}