package com.sean.lieb.mysuperheroapplication.networking

import android.util.Log
import android.util.Log.d
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.sean.lieb.mysuperheroapplication.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * This class sets up the details for connecting to the api
 * @param queryType - specify the type of query to be made to the api
 * @param queryValue - The value to be passed to the api (eg "search, or
 */
class SuperheroClient {
    val TAG = javaClass.simpleName
    private val BaseUrl = "https://www.superheroapi.com/"

    fun makeSuperHeroService() :SuperheroService{
        return Retrofit.Builder()
             .baseUrl(BaseUrl)
             .addConverterFactory(GsonConverterFactory.create())
             .build().create(SuperheroService::class.java)
//        val service: SuperheroService = retrofit.create(SuperheroService::class.java)
    }

    /*
    * implements "/search/name" in Superhero api
    * */
   suspend fun searchSuperhero(queryType :String, queryValue :String ) : ArrayList<Superhero>? {
    d(TAG,"getting Data")
    d(TAG, "Searching for: $queryValue")
        var result : ArrayList<Superhero>? = null
        val serve = makeSuperHeroService()

//        CoroutineScope(Dispatchers.IO).launch {
            val call = serve.getSearchNameResults(queryType,queryValue)
//            withContext(Dispatchers.Main) {
                call.enqueue(object : Callback<SuperheroResponse> {
                    override fun onResponse(call: Call<SuperheroResponse>, response: Response<SuperheroResponse>) {
                        if (response.code() == 200) {
                            d(TAG, "Response OK!")
                           val superHeroResponse = response.body()!!
                            val results = superHeroResponse.results
        d(TAG, "Heroes returened: $results")
                            for ( hero in results) {
                                result?.add(hero)
                                d(TAG, "Hero found: $hero")
                            }
                        }
                    }
                    override fun onFailure(call: Call<SuperheroResponse>, error: Throwable) {

                        d(TAG, "Response NOT OK! Error: \n $error")
                    }
                })
//            }
//        }
//        val call = service.getSearchNameResults(queryType, queryValue)

        return result
    }

}