package ru.kipdev.reminder

import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 4)
    }

    @Test
    fun getTimeText(){
        assertEquals(ru.kipdev.reminder.utils.getTimeText(0, 0), "00:00")
        assertEquals(ru.kipdev.reminder.utils.getTimeText(23, 0), "23:00")
        assertEquals(ru.kipdev.reminder.utils.getTimeText(15, 20), "15:20")
    }
}