package com.example.storage.service.impl

import com.example.storage.entity.Car
import com.example.storage.entity.RepairPart
import com.example.storage.entity.enums.RepairPartGroup
import com.example.storage.repository.RepairPartRepository
import com.example.storage.service.abstracts.RepairPartsService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random

@Service
@Transactional
class RepairPartsServiceImpl(private val repairPartRepository: RepairPartRepository) : RepairPartsService {
    override fun createRepairParts() : Any{
        for (i in 1..50) {
            var repairPart = RepairPart(null, "", "", 0, LocalDateTime.now(), mutableSetOf(), null)
            repairPart.repairPartGroup = generateRandomPartGroup()
            repairPart.code = Random.nextInt(100000, 10000000).toString()
            repairPart.resource = Random.nextInt(0, 650000)
            repairPartRepository.save(repairPart)
        }
        return true
    }

    override fun findAllPartsByCarId(id: Long): List<RepairPart> {
        return repairPartRepository.findAllByCarsId(id)
    }

    override fun findPartById(): RepairPart {
        return repairPartRepository.findById(Random.nextInt(1, 50).toLong())!!.get()
    }

    private fun generateRandomPartGroup() : RepairPartGroup {
        val values: Array<RepairPartGroup> = RepairPartGroup.entries.toTypedArray()
        return RepairPartGroup.entries[Random.nextInt(values.size)]
    }
}