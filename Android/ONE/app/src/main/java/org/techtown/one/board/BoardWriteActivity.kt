package org.techtown.one.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.techtown.one.R
import org.techtown.one.databinding.ActivityBoardWriteBinding
import org.techtown.one.utils.FBAuth
import org.techtown.one.utils.FBRef
import java.text.SimpleDateFormat
import java.util.*

class BoardWriteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardWriteBinding

    private val TAG = BoardWriteActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_board_write)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)

        binding.writeBtn.setOnClickListener{
            val title = binding.titleArea.text.toString()
            val content = binding.contentArea.text.toString()
            val uid = FBAuth.getUid()
            val time = FBAuth.getTime()

            Log.d(TAG, title)
            Log.d(TAG, content)

            //데이터 구
            //board
            //  -key
            //      -boardModel(title, content, uid, time)

            FBRef.boardRef
                .push()
                .setValue(BoardModel(title, content, uid, time))

            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()

            finish()
        }


    }
}

//class BoardWriteActivity : AppCompatActivity() {
//
//    private lateinit var binding : ActivityBoardWriteBinding
//
//    private val TAG = BoardWriteActivity::class.java.simpleName
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_board_write)
//
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_write)
//
//        binding.writeBtn.setOnClickListener{
//            val title = binding.titleArea.text.toString()
//            val content = binding.contentArea.text.toString()
//            val uid = FBAuth.getUid()
//            val time = FBAuth.getTime()
//
//            Log.d(TAG, title)
//            Log.d(TAG, content)
//
//            //데이터 구조
//            //board
//            //  -key
//            //      -boardModel(title, content, uid, time)
//
//
//            FBRef.boardRef
//                .push()
//                .setValue(BoardModel(title, content, uid, time))
//
//            Toast.makeText(this, "게시글 입력 완료", Toast.LENGTH_LONG).show()
//
//            finish()
//        }
//
//
//    }
//}