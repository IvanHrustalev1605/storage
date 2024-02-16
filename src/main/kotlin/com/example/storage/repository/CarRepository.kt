package com.example.storage.repository;

import com.example.storage.entity.Car
import org.springframework.data.jpa.repository.JpaRepository

interface CarRepository : JpaRepository<Car, Long> {

}