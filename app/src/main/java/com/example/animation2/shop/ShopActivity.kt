package com.example.animation2.shop

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.animation2.R
import com.example.animation2.fragments.PurchaseFragment
import com.example.animation2.fragments.ShopCartFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShopActivity : AppCompatActivity() {

    val shopCart = ShopCart()
    private var isShop=true

    private lateinit var toolbarTB: Toolbar
    private lateinit var floatingActionBTN: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        init()

        floatingActionBTN.setOnClickListener {
            if(isShop) {
                isShop=false
                startShopCartFragment(ShopCartFragment())
                floatingActionBTN.animate().apply {
                    rotation(360.0f)
                    duration=500
                }.start()
            } else {
                startShopCartFragment(PurchaseFragment())
                floatingActionBTN.visibility= View.INVISIBLE
            }
        }
    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)

        floatingActionBTN = findViewById(R.id.floatingActionBTN)
    }

    private fun startShopCartFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finishAffinity()
        return super.onOptionsItemSelected(item)
    }
}