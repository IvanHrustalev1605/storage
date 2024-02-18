package com.example.storage.entity

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.time.LocalDate

@Entity
open class RepairProcess() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
    @Column
    open var plannedTime: LocalDate? = null
    @Column
    open var spentTime: LocalDate? = null
    @Column
    open var overTime: LocalDate? = null
    @Column
    open var repairPlace: String? = null

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    open var car: Car? = null

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    open var employees: MutableList<Employee>? = null

    @OneToMany(mappedBy = "repairProcess")
    open var repairParts: MutableList<RepairPart>? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RepairProcess

        if (id != other.id) return false
        if (plannedTime != other.plannedTime) return false
        if (spentTime != other.spentTime) return false
        if (overTime != other.overTime) return false
        if (repairPlace != other.repairPlace) return false
        if (car != other.car) return false
        if (employees != other.employees) return false
        if (repairParts != other.repairParts) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (plannedTime?.hashCode() ?: 0)
        result = 31 * result + (spentTime?.hashCode() ?: 0)
        result = 31 * result + (overTime?.hashCode() ?: 0)
        result = 31 * result + (repairPlace?.hashCode() ?: 0)
        result = 31 * result + (car?.hashCode() ?: 0)
        result = 31 * result + (employees?.hashCode() ?: 0)
        result = 31 * result + (repairParts?.hashCode() ?: 0)
        return result
    }

}
