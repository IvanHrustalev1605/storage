package com.example.storage.entity

import com.example.storage.entity.enums.EmployeePosition
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "drivers", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
open class Driver() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
    @Column(unique = true)
    open var licenseNumber: String? = null
    @Column
    open var licenseExpiryDate: LocalDate? = null
    @Column
    open var vehicleType: String? = null
    @Column
    open var rating: Double? = null
    @Column
    open var position: EmployeePosition = EmployeePosition.DRIVER
    @Embedded
    open var personInfo: PersonInfo? = null

    @ManyToMany(mappedBy = "drivers")
    open var cars: MutableList<Car>? = mutableListOf()
}