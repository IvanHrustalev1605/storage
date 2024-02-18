package com.example.storage.controllers

import com.example.storage.entity.Car
import com.example.storage.entity.RepairPart
import com.example.storage.service.abstracts.CarService
import com.example.storage.service.abstracts.RepairPartService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/storage/cars")
class StorageCarController(private val carService: CarService) {

    @GetMapping("/create")
    fun createCars() : ResponseEntity<Boolean> {
        return ResponseEntity(carService.createCars(), HttpStatus.CREATED)
    }
    @GetMapping("/car-by-id")
    fun getCarById(@RequestParam("id") id: Long) : ResponseEntity<Car> {
        return ResponseEntity(carService.findCarById(id), HttpStatus.OK)
    }
    @GetMapping("/car-by-vin")
    fun getCarByVinNumber(@RequestParam("vin") vin: String): ResponseEntity<Car> {
        return ResponseEntity(carService.findCarByVin(vin), HttpStatus.OK)
    }
    @PostMapping("/save")
    fun saveCar(@RequestBody car: Car) : ResponseEntity<Boolean> {
        return ResponseEntity(carService.saveCar(car), HttpStatus.CREATED)
    }
}