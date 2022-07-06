package com.learn.noteapp.util;

import androidx.room.TypeConverter;
import java.util.*

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date:Date) :Long{
        return date.time
    }

    @TypeConverter
    fun dateStampFromDate(timeStamp:Long) :Date?{
        return Date(timeStamp)
    }
}
