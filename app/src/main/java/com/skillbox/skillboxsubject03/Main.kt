package com.skillbox.skillboxsubject03

import java.util.ArrayList

fun main() {

    val numbersList: ArrayList<Int>
    var positiveNumbers = 0
    val map = mapOf<Int, Int>()
    val dividerView = map.toMutableMap()


    println("Введи количество чисел:")

    val numberAmount: Int? = readLine()?.toIntOrNull()

    if (numberAmount != null) {
        numbersList = getNumbersList(numberAmount)
        for (number in numbersList) {
            if (number > 0) {
                positiveNumbers++
            }
            val biggestCommonDivider: Int = biggestDivider(number, numbersList.sum())
            dividerView.put(number, biggestCommonDivider)
        }

        val uniqueNumbers = setOf<Int>().union(numbersList)
        val allEvenNumbers = numbersList.filter { it % 2 == 0 }

        println("Количество положительных чисел: $positiveNumbers")

        if (allEvenNumbers.isNotEmpty()) {
            println("Четные числа: $allEvenNumbers")
        } else {
            println("четных чисел нет")
        }

        println("Количество уникальных чисел: ${uniqueNumbers.size}")

        println("Сумма всех чисел: ${numbersList.sum()}")

        println("Число=НОД $dividerView")

        for (number in numbersList) {

            println("Число $number, Сумма ${numbersList.sum()}, НОД ${dividerView[number]}")
        }


    } else {
        println("Некорректный ввод")
    }


}

fun getNumbersList(n: Int): ArrayList<Int> {
    val range = 0 until n
    val numbersList = ArrayList<Int>()
    for (number in range) {
        println("Введи ${number + 1}-e число: ")
        readLine()?.toIntOrNull()
            ?.let { number ->
                numbersList.add(number)
            }
            ?: continue
    }
    return numbersList
}

tailrec fun biggestDivider(a: Int, b: Int): Int {
    return if (b == 0) {
        a
    } else {
        biggestDivider(b, a % b)
    }
}

