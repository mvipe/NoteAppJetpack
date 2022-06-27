package com.learn.noteapp.data

import com.learn.noteapp.model.Note

class NoteDataSource{
    fun loadNotes():List<Note>{
        return listOf(
            Note(title="A good day", desc = "Day Night"),
            Note(title="A good day", desc = "Day Night"),
            Note(title="A good day", desc = "Day Night"),
            Note(title="A good day", desc = "Day Night")

        )
    }
}