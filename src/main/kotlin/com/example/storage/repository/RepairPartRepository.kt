package com.example.storage.repository;

import com.example.storage.entity.RepairPart
import org.springframework.data.jpa.repository.JpaRepository

interface RepairPartRepository : JpaRepository<RepairPart, Long> {
    fun findAllByInstalledFalse() : List<RepairPart>
}