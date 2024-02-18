package com.example.storage.service.abstracts

import com.example.storage.entity.Employee

interface EmployeeService {
    fun createEmployees() : Boolean
    fun findById(id: Long) : Employee
}