package com.sean.lieb.mysuperheroapplication

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.Menu
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sean.lieb.mysuperheroapplication.database.SuperheroRepository
import com.sean.lieb.mysuperheroapplication.databinding.ActivityMainBinding
import com.sean.lieb.mysuperheroapplication.networking.Superhero
import com.sean.lieb.mysuperheroapplication.networking.SuperheroClient
import com.sean.lieb.mysuperheroapplication.ui.home.HomeViewModel
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
//    var viewModel: HomeViewModel by lazy {  }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val TAG = javaClass.simpleName!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        testScope()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        var viewModel = HomeViewModel()

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Searching for superhero, check the log", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        val search = search()
           if (search.isCompleted) // completed yet no data
               d(TAG, "Search Completed! $search")
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
    }

    fun search() = runBlocking {
//        var searchResult: ArrayList<Superhero>
        launch {
    //            viewModel = ViewModelProvider(this, MyViewModelFactory(SuperheroRepository)).get(HomeViewModel::class.java)
                val client = SuperheroClient()
                 val searchResult = client.searchSuperhero("search", "Wonder")
                d(TAG,"Search Results: ")
                if (searchResult != null) {
                    for (hero in searchResult)
                        d(TAG, hero.toString())
                }
            }
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

    fun testScope() = runBlocking { // this: CoroutineScope
        launch {
            delay(200L)
            println("Task from runBlocking")
        }

        coroutineScope { // Creates a new coroutine scope
            launch {
                delay(900L)
                println("Task from nested launch")
            }

            delay(100L)
            println("Task from coroutine scope") // This line will be printed before nested launch
        }

        println("Coroutine scope is over") // This line is not printed until nested launch completes
    }



}