package com.sean.lieb.mysuperheroapplication.ui.home

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sean.lieb.mysuperheroapplication.networking.Superhero
import com.sean.lieb.mysuperheroapplication.networking.SuperheroClient
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job

class HomeViewModel : ViewModel() {
    val TAG = javaClass.simpleName
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    var superHeroList = MutableLiveData<List<Superhero>>()
//    var returnList = ArrayList<Superhero>()
//    var job: Job? = null
//
//    val loading = MutableLiveData<Boolean>()
//
    suspend fun searchForSuperHero(){
        val client = SuperheroClient()
//
        this.superHeroList.value = client.searchSuperhero("search", "woman")!!
    d(TAG,"SuperHeroes returned: "+this.superHeroList.value)
////       superHeroList = client.searchSuperhero("search", "woman")
////        for (hero in returnList)
////        if (searchSuperhero != null) {
////            for (hero in searchSuperhero)
////                Log.d(TAG, "Hero returned: $hero")
////        }else
////            Log.d(TAG, "No Hero Found")
    }

//    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        onError("Exception handled: ${throwable.localizedMessage}")
//    }
}