package com.example.storage.controllers

import com.example.storage.dto.CarDto
import com.example.storage.entity.Car
import com.example.storage.entity.RepairPart
import com.example.storage.service.abstracts.CarService
import com.example.storage.service.abstracts.RepairPartsService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController(private val carService: CarService,
                     private val repairPartsService: RepairPartsService) {

    @GetMapping
    fun createCars() : ResponseEntity<Boolean> {
        return ResponseEntity(carService.createCar(), HttpStatusCode.valueOf(200))
    }
    @GetMapping("/parts")
    fun createParts() : ResponseEntity<Any>? {
        return ResponseEntity(repairPartsService.createRepairParts(), HttpStatusCode.valueOf(200))
    }
    @GetMapping("/cars")
    fun getRepairParts(@RequestParam(name = "id") id : Long) : ResponseEntity<MutableSet<RepairPart>> {
        return ResponseEntity(carService.getRepairPartsByCarId(id), HttpStatusCode.valueOf(200))
    }
    @GetMapping("/getCarById")
    fun getById(@RequestParam("id") id: Long) : ResponseEntity<CarDto> {
        return ResponseEntity(carService.getCar(id), HttpStatusCode.valueOf(200))
    }
}