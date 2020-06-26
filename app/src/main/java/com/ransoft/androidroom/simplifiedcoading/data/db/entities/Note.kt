package com.ransoft.androidroom.simplifiedcoading.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_NOTE_ID = 0

@Entity
data class Note(
    val title: String,
    val note: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = CURRENT_NOTE_ID
}