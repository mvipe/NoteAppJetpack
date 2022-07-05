package com.learn.noteapp.data

import androidx.room.*
import com.learn.noteapp.model.Note

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from notes_tbl")
    fun getNote():List<Note>

    @Query("SELECT * from notes_tbl where id=:id")
    fun getNoteById(id:String) :Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note:Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("DELETE from notes_tbl")
    fun deleteAll()

    @Delete
    fun delete(note: Note)
}
