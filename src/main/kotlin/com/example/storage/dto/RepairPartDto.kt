package com.example.storage.dto

import com.example.storage.entity.enums.RepairPartGroup
import java.io.Serializable
import java.time.LocalDateTime

/**
 * DTO for {@link com.example.storage.entity.RepairPart}
 */
data class RepairPartDto(
    val id: Long? = null,
    val type: String? = null,
    val code: String? = null,
    val resource: Int? = null,
    val installationTime: LocalDateTime? = null,
    val repairPartGroup: RepairPartGroup? = null
) : Serializable