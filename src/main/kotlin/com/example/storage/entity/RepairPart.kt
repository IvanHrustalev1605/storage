package com.example.storage.entity

import com.example.storage.entity.enums.RepairPartGroup
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "repairParts")
open class RepairPart(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,

    @Column(name = "code", unique = true)
    open var code: String,

    @Column(name = "resource")
    open var resource: Int,

    @Column(name = "installationTime")
    open var installationTime: LocalDateTime,

    @Column
    open var installed: Boolean = false,

    @Enumerated
    open var repairPartGroup: RepairPartGroup?
)
