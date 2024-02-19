package com.example.storage.controllers

import com.example.storage.entity.Driver
import com.example.storage.entity.Employee
import com.example.storage.service.abstracts.EmployeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/storage/employees")
class StorageEmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/create")
    fun createCars() : ResponseEntity<Boolean> {
        return ResponseEntity(employeeService.createEmployees(), HttpStatus.CREATED)
    }
    @GetMapping("/employee-by-id")
    fun getDriverById(@RequestParam("id") id: Long) : ResponseEntity<Employee> {
        return ResponseEntity(employeeService.findById(id), HttpStatus.OK)
    }
}