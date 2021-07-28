package com.sean.lieb.mysuperheroapplication.networking

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

const val API_ACCESS_TOKEN = "10158286666522709" // My personal access token generated from API website

interface SuperheroService {
    // eg:  https://www.superheroapi.com/api.php/10158286666522709/search/wonder // (eg Search for Wonder Woman)
    @GET("api/$API_ACCESS_TOKEN/{type}/{name}")
     fun getSearchNameResults(@Path("type") queryType:String, @Path("name") queryValue:String): Call<SuperheroResponse>

}