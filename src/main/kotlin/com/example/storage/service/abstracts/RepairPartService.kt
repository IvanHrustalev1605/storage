package com.example.storage.service.abstracts

import com.example.storage.entity.RepairPart

interface RepairPartService {
    fun createRepairParts() : Boolean
    fun getAllNotInstalledParts() : List<RepairPart>
}