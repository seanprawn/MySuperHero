package com.sean.lieb.mysuperheroapplication.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SuperheroDAO {

    @Insert
    fun insert(vararg superhero: Superhero)

    @Insert
    fun insertAll(vararg superheroes: Superhero)

    @Delete
    fun delete(superhero: Superhero)

    @Query("SELECT * FROM superheroes")
    fun getAll(): Flow<List<Superhero>>
}