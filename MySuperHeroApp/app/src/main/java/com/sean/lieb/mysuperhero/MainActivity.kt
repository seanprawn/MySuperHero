package com.sean.lieb.mysuperhero

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.sean.lieb.mysuperhero.databinding.ActivityMainBinding
//import com.sean.lieb.mysuperhero.ui.home.searchClassName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    val searchPackageName = "com.sean.lieb.SearchModule"
    private val searchClassName = "$searchPackageName.SearchActivity"

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
//            searchForSuperHero()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val buttonSearch : Button = findViewById(R.id.btn_load_Search)
//        val buttonSearch : Button = binding.btnLoadSearch
//            buttonSearch.setOnClickListener(
//            val intent = Intent(this@MainActivity,SearchActivity::class.java)
//            launchActivity(searchClassName)
//        )

    }

//    private fun launchActivity(searchClassName: String): View.OnClickListener? {
////        var intentSend = Intent(this, SearchActivity::class.java)
//    }

//    private fun launchActivity(className: String): View.OnClickListener? {
//        Intent().setClassName(packageName, className)
//            .also {
//                startActivity(it)
//            }
//    }

    internal fun searchForSuperHero(){
        Log.d(TAG,"getting Data")
        Log.d(TAG, "Searching for: $queryValue")
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SuperheroService::class.java)
        val call = service.getSearchNameResults(queryType, queryValue)

        call.enqueue(object : Callback<SuperheroResponse> {
            override fun onResponse(call: Call<SuperheroResponse>, response: Response<SuperheroResponse>) {
                if (response.code() == 200) {
                    Log.d(TAG, "Response OK!")
                    val superHeroResponse = response.body()!!
                    Log.d(TAG, "Results came back for: "+superHeroResponse.resultsFor)
                }
            }
            override fun onFailure(call: Call<SuperheroResponse>, t: Throwable) {

                Log.d(TAG, "Response NOT OK! Error: \n $t")
            }
        })

    }

    companion object {
        var BaseUrl = "https://www.superheroapi.com/"
        var queryType = "search/"
        var queryValue = "Wonder"
    }


        override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}