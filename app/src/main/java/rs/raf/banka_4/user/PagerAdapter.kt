package rs.raf.banka_4.user

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.banka_4.user.fragments.HomeFragment
import rs.raf.banka_4.user.fragments.KarticeFragment
import rs.raf.banka_4.user.fragments.PlatiFragment
import rs.raf.banka_4.user.fragments.ViseFragment
import rs.raf.banka_4.user.fragments.racuni.RacuniFragment

class PagerAdapter(
    private val context : Context,
    fm: FragmentManager,
    internal var totalTabs: Int
) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0->return HomeFragment()
            1->return RacuniFragment()
            2->return PlatiFragment()
            3->return KarticeFragment()
            4->return ViseFragment()
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return totalTabs
    }
}