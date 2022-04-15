package org.techtown.mysololife.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import org.techtown.mysololife.R
import org.techtown.mysololife.databinding.FragmentStoreBinding
import org.techtown.mysololife.databinding.FragmentTalkBinding


class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)

        binding.homeTap.setOnClickListener{
            findNavController().navigate(R.id.action_storeFragment_to_homeFragment)
        }

        binding.tipTap.setOnClickListener{
            findNavController().navigate(R.id.action_storeFragment_to_tipFragment)
        }

        binding.talkTap.setOnClickListener{
            findNavController().navigate(R.id.action_storeFragment_to_talkFragment)
        }

        binding.bookmarkTap.setOnClickListener{
            findNavController().navigate(R.id.action_storeFragment_to_bookmarkFragment)
        }

        return binding.root
    }

}