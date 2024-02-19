package com.example.storage.controllers

import com.example.storage.entity.Driver
import com.example.storage.service.abstracts.DriverService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/storage/drivers")
class StorageDriverController(private val driverService: DriverService) {

    @GetMapping("/create")
    fun createCars() : ResponseEntity<Boolean> {
        return ResponseEntity(driverService.createDrivers(), HttpStatus.CREATED)
    }
    @GetMapping("/driver-by-id")
    fun getDriverById(@RequestParam("id") id: Long) : ResponseEntity<Driver> {
        return ResponseEntity(driverService.findById(id), HttpStatus.OK)
    }
    @GetMapping("/driver-by-license")
    fun getDriverByLicense(@RequestParam("license") license: String) : ResponseEntity<Driver> {
        return ResponseEntity(driverService.findByLicense(license), HttpStatus.OK)
    }
    @PostMapping("/save")
    fun saveDriver(@RequestBody driver: Driver) : ResponseEntity<Boolean> {
        return ResponseEntity(driverService.saveDriver(driver), HttpStatus.CREATED)
    }
}