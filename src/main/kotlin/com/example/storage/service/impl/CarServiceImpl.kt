package com.example.storage.service.impl

import com.example.storage.entity.Car
import com.example.storage.entity.enums.CarBrand
import com.example.storage.repository.CarRepository
import com.example.storage.service.GeneratorUtils
import com.example.storage.service.abstracts.CarService
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CarServiceImpl(private val carRepository: CarRepository) : CarService {
    override fun createCars(): Boolean {
        for (i in 1 .. 200) {
            val car = Car()
            car.carBrand = GeneratorUtils.generateCarBrand()
            car.mileage = Random.nextInt(100000, 1000000)
            car.model = GeneratorUtils.generateRandomString(6)
            car.number = GeneratorUtils.generateRandomString(8)
            car.vinNumber = GeneratorUtils.generateRandomString(14)
            carRepository.save(car)
        }
        return true
    }

    override fun saveCar(car: Car): Boolean {
        carRepository.save(car)
        return true
    }

    override fun findCarById(id: Long): Car {
        return carRepository.findById(id).orElseThrow { Exception(String.format("Машина по ID %d не найдена", id)) }
    }

    override fun findCarByVin(vin: String): Car {
        return carRepository.findByVinNumber(vin)
            .orElseThrow { Exception(String.format("Машина с VIN номером %s не найдена", vin)) }
    }


}