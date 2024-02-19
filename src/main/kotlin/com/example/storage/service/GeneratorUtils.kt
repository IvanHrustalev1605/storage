package com.example.storage.service

import com.example.storage.entity.PersonInfo
import com.example.storage.entity.enums.CarBrand
import com.example.storage.entity.enums.EmployeePosition
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.random.Random
@Service
class GeneratorUtils {

    companion object {
        private val chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray()
        private val maleNames = arrayOf("Александр", "Максим", "Иван", "Артем", "Дмитрий", "Никита", "Даниил", "Егор", "Сергей", "Кирилл", "Илья", "Роман", "Матвей", "Владимир", "Андрей", "Денис", "Алексей", "Евгений", "Глеб", "Тимофей", "Арсений", "Леонид", "Федор", "Игорь", "Павел", "Антон", "Вячеслав", "Михаил", "Константин", "Станислав")
        private val maleMiddleName = arrayOf( "Иванов", "Смирнов", "Кuznetsov", "Васильев", "Петров", "Михайлов",
            "Николаев", "Александров", "Морозов", "Павлов", "Соколов", "Лебедев",
            "Федоров", "Кузнецов", "Голубев", "Борисов", "Елисеев", "Новиков",
            "Макаров", "Дмитриев", "Тимофеев", "Панфилов", "Беловым", "Кравцов",
            "Степанов", "Ильин", "Попов", "Соловьёв", "Семёнов", "Тарасов")
        private val seconMaleNames = arrayOf("Алексеевич", "Андреевич", "Борисович", "Васильевич", "Витальевич",
            "Владимирович", "Геннадьевич", "Григорьевич", "Денисович", "Дмитриевич",
            "Евгеньевич", "Игоревич", "Ильич", "Казимирович", "Константинович",
            "Леонидович", "Максимович", "Матвеевич", "Михайлович", "Николаевич",
            "Олегович", "Павлович", "Романович", "Ростиславович", "Сергеевич",
            "Степанович", "Фёдорович", "Филиппович", "Юрьевич", "Ярославович")
        fun generateCarBrand() : CarBrand = CarBrand.entries[Random.nextInt(0, CarBrand.entries.size)]
        fun generateEmployeePosition() : EmployeePosition = EmployeePosition.entries[Random.nextInt(0, EmployeePosition.entries.size)]
        fun generateRandomString(length: Int): String = (1..length)
                .map { Random.nextInt(0, chars.size) }
                .map(chars::get)
                .joinToString("")
        fun generateRandomName() : String = maleNames[Random.nextInt(0, maleNames.size)]
        fun generateRandomSecondName() : String = seconMaleNames[Random.nextInt(0, seconMaleNames.size)]

        fun generateRandomMiddleName() : String = maleMiddleName[Random.nextInt(0, maleMiddleName.size)]
        fun generatePersonInfo() : PersonInfo = PersonInfo().also {
            it.firstName = generateRandomName();
            it.middleName = generateRandomMiddleName()
            it.secondName = generateRandomSecondName()
            it.age = Random.nextInt(18, 65)
            it.dopInfo = "Some text"
            it.createdAt = LocalDateTime.now()
            it.email = "dfd@mail.ru"
            it.login = generateRandomString(9)
        }

    }
}