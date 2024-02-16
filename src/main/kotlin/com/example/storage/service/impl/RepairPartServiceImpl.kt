package com.example.storage.service.impl

import com.example.storage.entity.RepairPart
import com.example.storage.entity.enums.RepairPartGroup
import com.example.storage.repository.RepairPartRepository
import com.example.storage.service.abstracts.RepairPartService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random

@Service
class RepairPartServiceImpl(private val repairPartRepository: RepairPartRepository) : RepairPartService {
    @Transactional
    override fun createRepairParts(): Boolean {
        for (i in 1 .. 500) {
            val repairPart = RepairPart(null, "", 0, LocalDateTime.now(), false, null)
            repairPart.code = Random.nextInt(100000, 1000000).toString()
            repairPart.repairPartGroup = generatePartGroup()
            repairPart.installationTime = LocalDateTime.now()
            repairPart.resource = Random.nextInt(30000, 100000)
            repairPartRepository.save(repairPart)
        }
        return true
    }

    override fun getAllNotInstalledParts(): List<RepairPart> {
        return repairPartRepository.findAllByInstalledFalse()
    }

    private fun generatePartGroup() : RepairPartGroup {
        return RepairPartGroup.entries[Random.nextInt(0, RepairPartGroup.entries.toTypedArray().size)]
    }
}