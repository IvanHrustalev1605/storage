package com.example.storage.dto

import com.example.storage.entity.RepairPart
import com.example.storage.entity.enums.CarBrand
import java.io.Serializable

/**
 * DTO for {@link com.example.storage.entity.Car}
 */
data class CarDto(
    val id: Long? = null,
    val model: String? = null,
    val number: String? = null,
    val mileage: Int? = null,
    val carBrand: CarBrand? = null,
    val repairParts: MutableSet<RepairPart> = mutableSetOf()
) : Serializable