package org.techtown.one.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import org.techtown.one.R
import org.techtown.one.board.BoardWriteActivity
import org.techtown.one.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("HomeFragment", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        //글쓰기 버튼을 눌렀을 경우 -> BoardWriteActivity로 이동시킴
        binding.writeBtn.setOnClickListener{
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }


        binding.writeTap.setOnClickListener{
            Log.d("HomeFragment", "tipTap")
            it.findNavController().navigate(R.id.action_homeFragment_to_writeFragment)

        }

        binding.listTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_listFragment)

        }

        binding.chatTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_chatFragment)

        }

        binding.userTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_userFragment)

        }

        return binding.root
    }


}