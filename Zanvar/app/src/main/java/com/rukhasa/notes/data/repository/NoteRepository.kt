package com.rukhasa.notes.data.repository

import com.rukhasa.notes.data.local.NoteDao
import com.rukhasa.notes.ui.note.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun insert(note: Note) = noteDao.insert(note)

    suspend fun update(note: Note) = noteDao.update(note)

    suspend fun delete(note: Note) = noteDao.delete(note)

    fun getNote(id: Int): Note = noteDao.getNote(id)

    fun getNotes(): Flow<List<Note>> = noteDao.getNotes()
}