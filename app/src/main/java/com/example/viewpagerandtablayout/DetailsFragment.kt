package com.example.viewpagerandtablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerandtablayout.databinding.FragmentDetailsBinding
import com.example.viewpagerandtablayout.databinding.FragmentSettingsBinding


class DetailsFragment : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = DetailsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}