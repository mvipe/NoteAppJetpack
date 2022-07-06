package com.learn.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.learn.noteapp.model.Note
import com.learn.noteapp.util.DateConverter
import com.learn.noteapp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class,UUIDConverter::class)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}