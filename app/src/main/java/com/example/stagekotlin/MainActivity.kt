package com.example.stagekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("test_manar", "onCreate: ")

/*    title = "kotlinapp"
  val fragmentManager: FragmentManager = supportFragmentManager
   val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
   val myFragment = MyFragment()
   TV.setOnClickListener()
   */

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController


     //   navController.navigate(R.id.homeFragment)
}


    override fun onResume() {
        super.onResume()
        Log.i("test_manar", "onResume: ")
    }

    override fun onStart() {
        super.onStart()
    }


    override fun onStop() {
        super.onStop()
        Log.i("test_manar", "onStop: ")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test_manar", "onDestroy: ")

    }

    override fun onPause() {
        super.onPause()
        Log.i("test_manar", "onPause: ")

    }

}
