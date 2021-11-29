package com.loper7.tablayout_ext.adapter

import androidx.fragment.app.*
import com.loper7.tablayout_ext.SimpleFragment

class SimpleFragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 4

    override fun getItem(position: Int): Fragment = SimpleFragment.newInstance("PAGE $position")

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "为你推荐"
            1 -> "二手房"
            2 -> "新房"
            3 -> "租房"
            else -> "海外"
        }
    }

}