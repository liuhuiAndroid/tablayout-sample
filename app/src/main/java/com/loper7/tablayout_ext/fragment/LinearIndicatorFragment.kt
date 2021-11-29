package com.loper7.tablayout_ext.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.loper7.tab_expand.ext.buildIndicator
import com.loper7.tab_expand.ext.buildText
import com.loper7.tab_expand.ext.toPx
import com.loper7.tab_expand.indicator.BaseIndicator
import com.loper7.tab_expand.indicator.CustomIndicator
import com.loper7.tablayout_ext.adapter.SimpleFragmentAdapter
import com.loper7.tab_expand.text.BaseText
import com.loper7.tablayout_ext.R
import kotlinx.android.synthetic.main.fragment_linear_indicator.*

class LinearIndicatorFragment : Fragment() {
    private lateinit var adapter: SimpleFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_linear_indicator, null)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SimpleFragmentAdapter(childFragmentManager)
        viewPager.adapter = adapter
        tabLayout_default.setupWithViewPager(viewPager)

        ContextCompat.getDrawable(requireContext(), R.drawable.centa_home_item_selected_container)?.let {
            tabLayout_default
                .buildIndicator<CustomIndicator>()
                .setDrawable(it)
                .setHeight(BaseIndicator.MATCH)
                .setWidth(BaseIndicator.MATCH)
                .bind()
        }
        tabLayout_default.buildText<BaseText>()
            .setNormalTextBold(false)
            .setSelectTextBold(true)
            .setNormalTextSize(14f)
            .setSelectTextSize(14f)
            .bind()
    }

}