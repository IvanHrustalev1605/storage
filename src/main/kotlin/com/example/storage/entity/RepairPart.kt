package com.example.storage.entity

import com.example.storage.entity.enums.RepairPartGroup
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "repairParts")
open class RepairPart() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "code", unique = true)
    open var code: String? = null

    @Column(name = "resource")
    open var resource: Int? = null

    @Column(name = "installationTime")
    open var installationTime: LocalDateTime? = null

    @Column
    open var installed: Boolean = false

    @Enumerated
    open var repairPartGroup: RepairPartGroup? = null

    @ManyToOne
    @JoinColumn
    open var car: Car? = null

    @ManyToOne
    @JoinTable
    open var repairProcess: RepairProcess? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RepairPart

        if (id != other.id) return false
        if (code != other.code) return false
        if (resource != other.resource) return false
        if (installationTime != other.installationTime) return false
        if (installed != other.installed) return false
        if (repairPartGroup != other.repairPartGroup) return false
        if (car != other.car) return false
        if (repairProcess != other.repairProcess) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (code?.hashCode() ?: 0)
        result = 31 * result + (resource ?: 0)
        result = 31 * result + installationTime.hashCode()
        result = 31 * result + installed.hashCode()
        result = 31 * result + (repairPartGroup?.hashCode() ?: 0)
        result = 31 * result + (car?.hashCode() ?: 0)
        result = 31 * result + (repairProcess?.hashCode() ?: 0)
        return result
    }

}
