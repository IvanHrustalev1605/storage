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
    open var type: String,

    @Column(name = "code", unique = true)
    open var code: String,

    @Column(name = "resource")
    open var resource: Int,

    @Column(name = "installationTime")
    open var installationTime: LocalDateTime,

    @ManyToMany(mappedBy = "repairParts", fetch = FetchType.EAGER)
    open var cars: MutableSet<Car> = mutableSetOf(),

    @Enumerated
    open var repairPartGroup: RepairPartGroup?
) {
    override fun toString(): String {
        return "RepairPart(id=$id, type='$type', code='$code', resource=$resource, installationTime=$installationTime, cars=$cars, repairPartGroup=$repairPartGroup)"
    }
}
