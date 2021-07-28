package com.sean.lieb.mysuperheroapplication.database

import kotlinx.coroutines.flow.Flow

class SuperheroRepository(private val heroDao: SuperheroDAO) {
    val allHeroes: Flow<List<Superhero>> = heroDao.getAll()

    suspend fun insert(hero: Superhero){
        heroDao.insert(hero)
    }
}