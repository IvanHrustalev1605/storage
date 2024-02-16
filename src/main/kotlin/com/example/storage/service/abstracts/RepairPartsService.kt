package com.example.storage.service.abstracts

import com.example.storage.entity.RepairPart

interface RepairPartsService {
    fun createRepairParts() : Any
    fun findPartById() : RepairPart
    fun findAllPartsByCarId(id : Long) : List<RepairPart>
}