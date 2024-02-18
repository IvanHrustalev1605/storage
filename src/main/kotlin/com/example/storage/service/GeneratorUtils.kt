package com.example.storage.service

import com.example.storage.entity.enums.CarBrand
import com.example.storage.entity.enums.EmployeePosition
import org.springframework.stereotype.Service
import kotlin.random.Random
@Service
class GeneratorUtils {

    companion object {
        private val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()
        private val maleNames = arrayOf("Александр", "Максим", "Иван", "Артем", "Дмитрий", "Никита", "Даниил", "Егор", "Сергей", "Кирилл", "Илья", "Роман", "Матвей", "Владимир", "Андрей", "Денис", "Алексей", "Евгений", "Глеб", "Тимофей", "Арсений", "Леонид", "Федор", "Игорь", "Павел", "Антон", "Вячеслав", "Михаил", "Константин", "Станислав")

        fun generateCarBrand() : CarBrand = CarBrand.entries[Random.nextInt(0, CarBrand.entries.size)]
        fun generateEmployeePosition() : EmployeePosition = EmployeePosition.entries[Random.nextInt(0, EmployeePosition.entries.size)]
        fun generateRandomString(length: Int): String = (1..length)
                .map { Random.nextInt(0, chars.size) }
                .map(chars::get)
                .joinToString("")
        fun generateRandomName() : String = maleNames[Random.nextInt(0, maleNames.size)]

    }
}