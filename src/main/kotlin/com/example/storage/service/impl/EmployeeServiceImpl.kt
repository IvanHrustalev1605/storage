package com.example.storage.service.impl

import com.example.storage.entity.Employee
import com.example.storage.repository.EmployeeRepository
import com.example.storage.service.GeneratorUtils
import com.example.storage.service.abstracts.EmployeeService
import jakarta.transaction.Transactional
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class EmployeeServiceImpl(private val employeeRepository: EmployeeRepository) : EmployeeService {
    @Transactional
    override fun createEmployees(): Boolean {
        for (i in 1 .. 59) {
            val employee = Employee()
            employee.name = GeneratorUtils.generateRandomString(5)
            employee.distinctiveDocument = Random.nextInt(6, 6).toString()
            employee.position = GeneratorUtils.generateEmployeePosition()
            employeeRepository.save(employee)
        }
        return true
    }

    override fun findById(id: Long): Employee {
        return employeeRepository.findById(id).orElseThrow { Exception(String.format("Сотрудник с ID %d не найден!", id)) }
    }
}