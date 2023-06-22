package com.hackx.hackx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavBar: com.ismaeldivita.chipnavigation.ChipNavigationBar

    private val forumFragment by lazy { ForumFragment() }
    private val cFragment by lazy { cFragment() }
    private val birFragment by lazy { birFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCurrentFragment(birFragment)

        bottomNavBar = findViewById(R.id.bottom_nav_bar)
        bottomNavBar.setOnItemSelectedListener { id ->
            val selectedFragment = when (id) {
                R.id.a_id -> forumFragment
                R.id.aa_id -> cFragment
                else -> birFragment
            }
            makeCurrentFragment(selectedFragment)
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
    }
}