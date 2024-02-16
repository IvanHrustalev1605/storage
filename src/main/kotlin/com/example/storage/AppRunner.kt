package com.example.storage

import com.example.storage.service.abstracts.CarService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Service

@Service
class AppRunner(private val carService: CarService) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println(carService.getRepairPartsByCarId(26))
    }
}