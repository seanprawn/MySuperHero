package com.sean.lieb.mysuperhero.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sean.lieb.mysuperhero.R
import com.sean.lieb.mysuperhero.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    val TAG = javaClass.simpleName

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
//        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

//        val buttonSearch: Button = View.findViewById(R.id.btn_load_Search)


        return root
    }



//    private val clickListener by lazy {
//        View.OnClickListener {
//            when (it.id) {
//                Log.d(TAG, "Launching: $searchClassName")
//                butt -> launchActivity(searchClassName)
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    /** Launch an activity by its class name. */
//    private fun launchActivity(className: String): View.OnClickListener? {
//        Intent().setClassName(packageName, className)
//            .also {
//                startActivity(it)
//            }
//    }

//    /** Set up all view variables. */
//    private fun initializeViews() {
//        setupClickListener()
//    }

//    /** Set all click listeners required for the buttons on the UI. */
//    private fun setupClickListener() {
//
//        setClickListener(R.id.btn_load_Search, clickListener)
//    }

//    private fun setClickListener(id: Int, listener: View.OnClickListener) {
//        activity?.findViewById<View>(id)?.setOnClickListener(listener)
//    }

}