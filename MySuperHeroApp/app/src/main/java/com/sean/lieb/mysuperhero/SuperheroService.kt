package com.sean.lieb.mysuperhero

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SuperheroService {
    // eg:  https://www.superheroapi.com/api.php/10158286666522709/search/wonder // (eg Search for Wonder Woman)
    @GET("api/10158286666522709/{type}/{name}")
    fun getSearchNameResults(@Path("type") queryType:String,@Path("name") queryValue:String): Call<SuperheroResponse>
}