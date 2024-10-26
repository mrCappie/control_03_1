package org.example

fun main() {

    println(agoToText(10))
    println(agoToText(555))
    println(agoToText(84000))
    println(agoToText(90000))

}

fun agoToText(seconds: Int): String {
    val min = 60
    val hour = 60 * min
    val day = 24 * hour

    var message: String

    if (seconds <= min) {
        message = "был(а) только что"
    } else if (seconds in (min + 1)..hour) {
        val minutes = seconds / min
        val wordMinutes = minutesWord(minutes)
        message = "был(а) $minutes $wordMinutes назад"
    } else if (seconds in (hour + 1)..day) {
        val hours = seconds / hour
        val hoursWord = hoursWord(hours)
        message = "был(а) $hours $hoursWord назад"
    } else if (seconds > day && seconds <= 2 * day) {
        message = "был(а) вчера"
    } else if (seconds > 2 * day && seconds <= 3 * day) {
        message = "был(а) позавчера"
    } else {
        message = "был(а) давно"
    }

    return message
}

fun minutesWord(minutes: Int) = if (minutes in 11..14) {
    "минут"
} else
    when (minutes % 10) {
        1 -> "минут"
        2, 3, 4 -> "минуты"
        else -> "минут"
    }

fun hoursWord(hours: Int): String = if (hours in 5..20) {
    "часов"
} else
    when (hours % 10) {
        1, 21 -> "час"
        else -> "часа"
    }

