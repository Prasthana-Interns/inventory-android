package com.example.inventory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.inventory.databinding.ActivityAdminScreenOneBinding
import com.google.android.material.tabs.TabLayoutMediator

var binding: ActivityAdminScreenOneBinding?=null

var fragmentsArray= arrayOf("Employee","Devices","Approvals")

class AdminScreenOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminScreenOneBinding.inflate(layoutInflater)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        val view = binding!!.root
        setContentView(view)

        val viewPager = binding!!.viewPager
        val tabLayout = binding!!.tabLayout


        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = fragmentsArray[position]
        }.attach()
    }
}