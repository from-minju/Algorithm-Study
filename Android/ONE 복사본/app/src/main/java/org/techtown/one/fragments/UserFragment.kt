package org.techtown.one.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.techtown.one.R
import org.techtown.one.databinding.FragmentUserBinding


class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false)

        binding.homeTap.setOnClickListener{
            findNavController().navigate(R.id.action_userFragment_to_homeFragment)
        }

        binding.writeTap.setOnClickListener{
            findNavController().navigate(R.id.action_userFragment_to_writeFragment)
        }

        binding.listTap.setOnClickListener{
            findNavController().navigate(R.id.action_userFragment_to_listFragment)
        }

        binding.chatTap.setOnClickListener{
            findNavController().navigate(R.id.action_userFragment_to_chatFragment)
        }

        return binding.root
    }

}