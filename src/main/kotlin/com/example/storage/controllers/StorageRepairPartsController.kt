package com.example.storage.controllers

import com.example.storage.entity.RepairPart
import com.example.storage.service.abstracts.RepairPartService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/storage/repairParts")
class StorageRepairPartsController(private val repairPartService: RepairPartService) {

    @GetMapping("/create")
    fun createParts() : ResponseEntity<Boolean> {
        return ResponseEntity(repairPartService.createRepairParts(), HttpStatusCode.valueOf(200))
    }
    @GetMapping("/parts-not-installed")
    fun getNotInstalledParts() : ResponseEntity<List<RepairPart>> {
        return ResponseEntity(repairPartService.getAllNotInstalledParts(), HttpStatusCode.valueOf(200))
    }
}