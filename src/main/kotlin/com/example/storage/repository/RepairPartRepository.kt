package com.example.storage.repository;

import com.example.storage.entity.RepairPart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RepairPartRepository : JpaRepository<RepairPart, Long> {
    fun findAllByCarsId(id : Long) : List<RepairPart>
}