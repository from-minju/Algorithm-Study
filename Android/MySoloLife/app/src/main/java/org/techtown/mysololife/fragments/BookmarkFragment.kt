package org.techtown.mysololife.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import org.techtown.mysololife.R
import org.techtown.mysololife.contentsList.ContentModel
import org.techtown.mysololife.databinding.FragmentBookmarkBinding
import org.techtown.mysololife.databinding.FragmentTalkBinding
import org.techtown.mysololife.utils.FBAuth
import org.techtown.mysololife.utils.FBRef


class BookmarkFragment : Fragment() {

    private lateinit var binding: FragmentBookmarkBinding

    private val TAG = BookmarkFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)

        //1. 전체 카테고리에 있는 컨텐츠 데이터들을 다 가져옴
        getCategoryData()
        //2. 사용자가 북마크한 정보를 다 가져옴
        getBookmarkData()
        //3. 전체 컨테츠 중 사용자가 북마크한 정보만 보여줌


        binding.homeTap.setOnClickListener{
            findNavController().navigate(R.id.action_bookmarkFragment_to_homeFragment)
        }

        binding.tipTap.setOnClickListener{
            findNavController().navigate(R.id.action_bookmarkFragment_to_tipFragment)
        }

        binding.talkTap.setOnClickListener{
            findNavController().navigate(R.id.action_bookmarkFragment_to_talkFragment)
        }

        binding.storeTap.setOnClickListener{
            findNavController().navigate(R.id.action_bookmarkFragment_to_storeFragment)
        }

        return binding.root
    }


    //1. 전체 카테고리에 있는 컨텐츠 데이터들을 다 가져옴
    private fun getCategoryData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())

                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "LoadPost:onCanceled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)

    }


    //2. 사용자가 북마크한 정보를 다 가져옴
    private fun getBookmarkData(){

        //파이어베이스에서 데이터를 가져옴(받아옴)
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (dataModel in dataSnapshot.children) {
                    Log.d(TAG, dataModel.toString())
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ContentListActivity", "LoadPost:onCanceled", databaseError.toException())
            }
        }

        FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListener)
    }
}