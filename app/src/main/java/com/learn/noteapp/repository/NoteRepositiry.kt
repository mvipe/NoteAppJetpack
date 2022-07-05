package com.learn.noteapp.repository

import com.learn.noteapp.data.NoteDatabaseDao
import com.learn.noteapp.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class NoteRepositiry @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
) {
    suspend fun addNote(note: Note) =noteDatabaseDao.insert(note=note)
    suspend fun updateNote(note: Note) =noteDatabaseDao.update(note)
    suspend fun deleteNote(note: Note) =noteDatabaseDao.delete(note)
    suspend fun deleteAllNote(note: Note)=noteDatabaseDao.deleteAll()
    fun getAllNotes():Flow<List<Note>> =noteDatabaseDao.getNotes()
        .flowOn(Dispatchers.IO)
        .conflate()
}