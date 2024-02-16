package com.example.storage.service.abstracts

import com.example.storage.dto.CarDto
import com.example.storage.entity.Car
import com.example.storage.entity.RepairPart

interface CarService {
    fun createCar() : Boolean
    fun getCar(id : Long) : CarDto
    fun getAllCars() : List<Car>
    fun getRepairPartsByCarId(id: Long) : MutableSet<RepairPart>
}