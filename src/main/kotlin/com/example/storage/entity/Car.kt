package com.example.storage.entity

import com.example.storage.entity.enums.CarBrand
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity(name = "cars")
@JsonIgnoreProperties(ignoreUnknown = true)
open class Car(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    open var id: Long? = null,

    @Column(name = "model", updatable = false)
    open var model: String,

    @Column(name = "number", unique = true, updatable = false)
    open  var number: String,

    //пробег
    @Column
    open var mileage: Int,

    @Enumerated(value = EnumType.STRING)
    open var carBrand: CarBrand?,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = [JoinColumn(name = "cars_id")],
        inverseJoinColumns = [JoinColumn(name = "repair_parts_id")])
    open var repairParts: MutableSet<RepairPart>
)
