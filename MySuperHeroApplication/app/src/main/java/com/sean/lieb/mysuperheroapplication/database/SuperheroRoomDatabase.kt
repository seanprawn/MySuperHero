package com.sean.lieb.mysuperheroapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Superhero::class), version = 1, exportSchema = false)
public abstract class SuperheroRoomDatabase : RoomDatabase() {
    abstract fun superheroDAO(): SuperheroDAO

    companion object {
        @Volatile
        private var INSTANCE: SuperheroRoomDatabase? = null

        fun getDatabase(context: Context): SuperheroRoomDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    SuperheroRoomDatabase::class.java,
                    "superhero_database"
                ).build()
                INSTANCE = instance
                instance // return instance
            }
        }
    }
}