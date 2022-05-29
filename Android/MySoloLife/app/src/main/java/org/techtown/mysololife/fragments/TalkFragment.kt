package org.techtown.mysololife.fragments

import android.content.Intent
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
import org.techtown.mysololife.board.BoardInsideActivity
import org.techtown.mysololife.board.BoardListLVAdapter
import org.techtown.mysololife.board.BoardModel
import org.techtown.mysololife.board.BoardWriteActivity
import org.techtown.mysololife.contentsList.BookmarkRVAdapter
import org.techtown.mysololife.contentsList.ContentModel
import org.techtown.mysololife.databinding.FragmentTalkBinding
import org.techtown.mysololife.databinding.FragmentTipBinding
import org.techtown.mysololife.utils.FBRef


class TalkFragment : Fragment() {

    private lateinit var binding: FragmentTalkBinding

    private val boardDataList = mutableListOf<BoardModel>()
    private val boardKeyList = mutableListOf<String>()

    private val TAG = TalkFragment::class.java.simpleName

    private lateinit var boardRVAdapter: BoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_talk, container, false)

        boardRVAdapter = BoardListLVAdapter(boardDataList)
        binding.boardListView.adapter = boardRVAdapter


        binding.boardListView.setOnItemClickListener{ parent, view, position, id ->

            //방법1 : 으로는 listview에 있는 데이터 title content time 다 다른 액티비티로 전달해줘서 만들기
//            val intent = Intent(context, BoardInsideActivity::class.java)
//            intent.putExtra("title", boardDataList[position].title)
//            intent.putExtra("content", boardDataList[position].content)
//            intent.putExtra("time", boardDataList[position].time)
//            startActivity(intent)


            //방법2 : 파이어베이스에 있는 board에 있는 데이터의 id를 기반으로 불러오는
            val intent = Intent(context, BoardInsideActivity::class.java)
            intent.putExtra("key", boardKeyList[position])
            startActivity(intent)

        }



        //글쓰기 버튼을 눌렀을 경우 -> BoardWriteActivity로 이동시킴
        binding.writeBtn.setOnClickListener{
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }



        binding.homeTap.setOnClickListener{
            findNavController().navigate(R.id.action_talkFragment_to_homeFragment)
        }

        binding.tipTap.setOnClickListener{
            findNavController().navigate(R.id.action_talkFragment_to_tipFragment)
        }

        binding.bookmarkTap.setOnClickListener{
            findNavController().navigate(R.id.action_talkFragment_to_bookmarkFragment)
        }

        binding.storeTap.setOnClickListener{
            findNavController().navigate(R.id.action_talkFragment_to_storeFragment)
        }

        getFBBoardData()

        return binding.root
    }


    private fun getFBBoardData(){
        //파이어베이스에서 데이터를 가져옴(받아옴)
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear() //boardDataList초기화시킴(같은 데이터가 중복되어 들어가기 때문)

                for (dataModel in dataSnapshot.children) {

                    Log.d(TAG, dataModel.toString())
//                    dataModel.key

                    //BoarModel타입으로 데이터를 받아옴
                    val item = dataModel.getValue(BoardModel::class.java)
                    boardDataList.add(item!!)
                    boardKeyList.add(dataModel.key.toString())
                }

                //데이터 동기화
                boardKeyList.reverse()
                boardDataList.reverse() //시간순으로 하기 위해 뒤집음
                boardRVAdapter.notifyDataSetChanged()
                Log.d(TAG, boardDataList.toString())

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "LoadPost:onCanceled", databaseError.toException())
            }
        }

        FBRef.boardRef.addValueEventListener(postListener)

    }

}