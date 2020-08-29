package uz.digitalgeneration.kkalcalculator.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DateWork {

    fun getStartAndEndOfTheDate(selectedDate: Date): Pair<Date, Date> {

        val threeIntegers = dateToSeperateThreeIntegers(selectedDate)

        val year = threeIntegers[0]
        val month = threeIntegers[1]
        val dayOfMonth = threeIntegers[2]

        val textStartDay = "${dayOfMonth}-${month}-${year} 00:00:00"
        val textEndDay = "${dayOfMonth}-${month}-${year} 23:59:59"

        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")

        val startDate = formatter.parse(textStartDay)
        val endDate = formatter.parse(textEndDay)

        return startDate to endDate
    }

    fun getStartAndEndOfWeek(selectedDate: Date): Pair<Int, Int> {

        val c = Calendar.getInstance()
        c.time = selectedDate

        val firstDayOfWeek = c.firstDayOfWeek
        val lastDayOfWeek = firstDayOfWeek + 6

        Log.d("weekss", "First is $firstDayOfWeek last is $lastDayOfWeek")

        return firstDayOfWeek to lastDayOfWeek
    }

    fun seperateIntegersToDate(year: Int, month: Int, dayOfMonth: Int): Date {

        val textDay = "${dayOfMonth}-${month + 1}-${year} 00:00:00"

        val formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")

        return formatter.parse(textDay)
    }

    fun dateToSeperateThreeIntegers(date: Date) : List<Int> {

        val threeIntegers = ArrayList<Int>()

        threeIntegers.add(date.year + 1900)
        threeIntegers.add(date.month + 1)
        threeIntegers.add(date.date)

        Log.d("mfff", "converting date year is ${threeIntegers[0]}, month is ${threeIntegers[1]}, day is ${date.date}")

        return threeIntegers
    }

}