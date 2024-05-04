package rs.raf.banka_4.user

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import rs.raf.banka_4.R
import rs.raf.banka_4.databinding.ActivityUserBinding

class UserActivity:AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        supportActionBar!!.hide()
        val view = binding.root
        setContentView(view)
        val tablayout = binding.activityUserTabLayout
        val viewPager = binding.activityUserViewPager

        tablayout.addTab(tablayout.newTab().setText("Home"))
        tablayout.addTab(tablayout.newTab().setText("Racuni"))
        tablayout.addTab(tablayout.newTab().setText("Plati"))
        tablayout.addTab(tablayout.newTab().setText("Kartice"))
        tablayout.addTab(tablayout.newTab().setText("Vise"))

        tablayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter  = PagerAdapter(this,supportFragmentManager,5)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        tablayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager!!.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        tablayout.getTabAt(0)!!.select()

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        // Set color for the bottom navigation bar if supported
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            window.navigationBarColor = resources.getColor(R.color.white)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            window.statusBarColor = resources.getColor(R.color.loading)
        }
    }
}