package com.ransoft.androidroom.simplifiedcoading.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ransoft.androidroom.simplifiedcoading.data.db.entities.Note

@Dao
interface NoteDao {

    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM note")
    fun getAllNotes() : List<Note>

    // Insert multiple notes at a time
    @Insert
    fun addMultipleNotes(vararg note: Note)
}