package org.techtown.one.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import org.techtown.one.R
import org.techtown.one.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        binding.homeTap.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_homeFragment)
        }

        binding.writeTap.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_writeFragment)
        }

        binding.chatTap.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_chatFragment)
        }

        binding.userTap.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_userFragment)
        }

        return binding.root
    }

}