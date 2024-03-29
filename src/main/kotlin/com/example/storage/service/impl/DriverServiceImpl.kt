package com.example.storage.service.impl

import com.example.storage.entity.Driver
import com.example.storage.repository.DriverRepository
import com.example.storage.service.GeneratorUtils
import com.example.storage.service.abstracts.DriverService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class DriverServiceImpl(private val driverRepository: DriverRepository) : DriverService {
    override fun createDrivers(): Boolean {
        for (i in 1 .. 60) {
            val driver = Driver()
            driver.licenseExpiryDate = LocalDate.now().plusDays(Random.nextLong(400, 1500))
            driver.rating = Random.nextDouble(3.0, 5.0)
            driver.vehicleType = "TRACK"
            driver.licenseNumber = GeneratorUtils.generateRandomString(23)
            driver.personInfo = GeneratorUtils.generatePersonInfo()
            driverRepository.save(driver)
        }
        return true
    }
    @Transactional
    override fun saveDriver(driver: Driver): Boolean {
        driverRepository.save(driver)
        return true
    }

    override fun findByLicense(license: String): Driver {
        return driverRepository.findByLicenseNumber(license).orElseThrow()
    }

    override fun findById(id: Long): Driver? {
        return driverRepository.findById(id).orElseThrow()
    }
}