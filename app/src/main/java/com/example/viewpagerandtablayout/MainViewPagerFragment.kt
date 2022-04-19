package com.example.viewpagerandtablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpagerandtablayout.databinding.FragmentMainViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IllegalArgumentException


class MainViewPagerFragment : Fragment() {

    private val tabIcons = arrayOf(
        R.drawable.ic_details,
        R.drawable.ic_home,
        R.drawable.ic_settings
    )

    private var _binding : FragmentMainViewPagerBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainViewPagerBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.viewPager.currentItem = 1 //For init in HomeFragment
        return binding.root
    }


    override fun onStart() {
        super.onStart()

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            //Values from resources
            tab.text = this.resources.getStringArray(R.array.tab_array)[position]
            tab.icon = ContextCompat.getDrawable(requireContext(), tabIcons[position])
        }.attach()

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    return DetailsFragment.newInstance()
                }
                1 -> {
                    return HomeFragment.newInstance()
                }
                2 -> {
                    return SettingsFragment.newInstance()
                }
                else -> {
                    throw IllegalArgumentException("There should not be more tabs")
                }
            }
        }

    }
}