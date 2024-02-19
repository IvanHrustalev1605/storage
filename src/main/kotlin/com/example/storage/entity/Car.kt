package com.example.storage.entity

import com.example.storage.entity.enums.CarBrand
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity(name = "cars")
@Table(name = "cars", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
open class Car() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "model", updatable = false)
    open var model: String? = null

    @Column(name = "number", unique = true, updatable = false)
    open  var number: String? = null

    @Column(unique = true, updatable = false)
    open var vinNumber: String? = null
    //пробег
    @Column
    open var mileage: Int? = null

    @Enumerated(value = EnumType.STRING)
    open var carBrand: CarBrand? = null

    @OneToMany(mappedBy = "car")
    open var repairParts: MutableSet<RepairPart>? = null

    @OneToOne(mappedBy = "car")
    @JoinColumn
    open var repairProcess: RepairProcess? = null

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(name = "cars_drivers",
        joinColumns = [JoinColumn(name = "car_id")],
        inverseJoinColumns = [JoinColumn(name = "driver_id")])
    open var drivers: MutableList<Driver>? = mutableListOf()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (id != other.id) return false
        if (model != other.model) return false
        if (number != other.number) return false
        if (vinNumber != other.vinNumber) return false
        if (mileage != other.mileage) return false
        if (carBrand != other.carBrand) return false
        if (repairParts != other.repairParts) return false
        if (drivers != other.drivers) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (model?.hashCode() ?: 0)
        result = 31 * result + (number?.hashCode() ?: 0)
        result = 31 * result + (vinNumber?.hashCode() ?: 0)
        result = 31 * result + (mileage ?: 0)
        result = 31 * result + (carBrand?.hashCode() ?: 0)
        result = 31 * result + (repairParts?.hashCode() ?: 0)
        result = 31 * result + (drivers?.hashCode() ?: 0)
        return result
    }


}