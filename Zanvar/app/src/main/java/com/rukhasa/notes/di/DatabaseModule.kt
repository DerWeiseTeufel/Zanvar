package com.rukhasa.notes.di

import android.content.Context
import androidx.room.Room
import com.rukhasa.notes.data.local.NoteDao
import com.rukhasa.notes.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DatabaseModule {
    @Provides
    @ViewModelScoped
    fun provideLocalDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase =
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note_database"
        ).allowMainThreadQueries().build()

    @Provides
    @ViewModelScoped
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDao = noteDatabase.noteDao()
}