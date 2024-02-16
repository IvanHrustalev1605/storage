package com.example.storage.service.impl

import com.example.storage.dto.CarDto
import com.example.storage.entity.Car
import com.example.storage.entity.RepairPart
import com.example.storage.entity.enums.CarBrand
import com.example.storage.repository.CarRepository
import com.example.storage.service.abstracts.CarService
import com.example.storage.service.abstracts.RepairPartsService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class CarServiceImpl(private val carRepository: CarRepository,
                     private val repairPartsService: RepairPartsService) : CarService {
    @Transactional
    override fun createCar(): Boolean {
        for (i in 1..150) {
            var car = Car(null, "", "", 0,null, mutableSetOf())
            car.model = i.toString()
            car.number = Math.random().toString()
            car.mileage = Random(190).nextInt(0, 19000)
            car.carBrand = generateRandomCarBrand()
            car.repairParts = mutableSetOf(repairPartsService.findPartById())
            carRepository.save(car)
        }
        return true
    }
    @Transactional
    override fun getCar(id: Long): CarDto {
        val car = carRepository.findById(id)!!.get()
        return CarDto(car.id, car.model, car.number, car.mileage, car.carBrand, car.repairParts)
    }

    override fun getAllCars(): MutableList<Car> {
        return carRepository.findAll()
    }

    override fun getRepairPartsByCarId(id: Long): MutableSet<RepairPart> {
        return carRepository.findById(id).get().repairParts
    }

    private fun generateRandomCarBrand() : CarBrand {
        val values: Array<CarBrand> = CarBrand.entries.toTypedArray()
        return CarBrand.entries[Random.nextInt(values.size)]
    }
}