package com.sean.lieb.mysuperheroapplication.database

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class SuperheroViewModel(private val repository: SuperheroRepository): ViewModel() {
    val allHeroes: LiveData<List<Superhero>> = repository.allHeroes.asLiveData()

    fun insert(hero: Superhero) = viewModelScope.launch {
        repository.insert(hero)
    }

    class HeroViewModelFactory(private val repository: SuperheroRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SuperheroViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SuperheroViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}