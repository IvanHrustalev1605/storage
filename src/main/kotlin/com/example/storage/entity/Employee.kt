package com.example.storage.entity

import com.example.storage.entity.enums.EmployeePosition
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity(name = "employee")
@Table(name = "employees", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true)
open class Employee() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null
    @Column
    open var name: String? = null
    //должность
    @Enumerated(value = EnumType.ORDINAL)
    open var position: EmployeePosition? = null
    @Column
    //какой-то документ типа паспорта
    open var distinctiveDocument: String? = null
    @Embedded
    open var personInfo: PersonInfo? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (id != other.id) return false
        if (name != other.name) return false
        if (position != other.position) return false
        if (distinctiveDocument != other.distinctiveDocument) return false
        if (personInfo != other.personInfo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (position?.hashCode() ?: 0)
        result = 31 * result + (distinctiveDocument?.hashCode() ?: 0)
        result = 31 * result + (personInfo?.hashCode() ?: 0)
        return result
    }

    //еще куча всяких полей
}
