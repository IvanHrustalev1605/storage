package com.example.storage.service.abstracts

import com.example.storage.entity.Car

interface CarService {
    fun createCars() : Boolean
    fun findCarByVin(vin: String) : Car
    fun saveCar(car: Car) : Boolean
    fun findCarById(id: Long) : Car
}