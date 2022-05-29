package org.techtown.mysololife.board

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import org.techtown.mysololife.R
import org.techtown.mysololife.databinding.ActivityBoardInsdieBinding
import org.techtown.mysololife.utils.FBAuth
import org.techtown.mysololife.utils.FBRef
import java.lang.Exception

class BoardInsideActivity : AppCompatActivity(){

    private val TAG = BoardInsideActivity::class.java.simpleName

    private lateinit var binding : ActivityBoardInsdieBinding

    private lateinit var key : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_insdie)

        binding.boardSettingIcon.setOnClickListener{
            showDialog()
        }

        //방법2 :
        key = intent.getStringExtra("key").toString()
        getBoardData(key)
        getImageData(key)

    }

    private fun showDialog(){

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("게시글 수정/삭제")

        val alertDialog = mBuilder.show()
        //수정
        alertDialog.findViewById<Button>(R.id.editBtn)?.setOnClickListener{
            Toast.makeText(this, "수정 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show()

            val intent = Intent(this, BoardEditActivity::class.java)
            intent.putExtra("key", key)
            startActivity(intent)

        }
        //삭제
        alertDialog.findViewById<Button>(R.id.removeBtn)?.setOnClickListener{
            FBRef.boardRef.child(key).removeValue()
            Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show()
            finish()
        }


   }

    private fun getImageData(key : String) {
        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference.child(key + ".png")

        // ImageView in your Activity
        val imageViewFromFB = binding.getImageArea

        storageReference.downloadUrl.addOnCompleteListener(OnCompleteListener { task ->
            if(task.isSuccessful) {
                Glide.with(this)
                    .load(task.result)
                    .into(imageViewFromFB)
            } else {

            }
        })

    }


    private fun getBoardData(key : String){

        //파이어베이스에서 데이터를 가져옴(받아옴)
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                try{
                    val dataModel = dataSnapshot.getValue(BoardModel::class.java)
                    Log.d(TAG, dataModel!!.title)

                    binding.titleArea.text = dataModel!!.title
                    binding.textArea.text = dataModel!!.content
                    binding.timeArea.text = dataModel!!.time

                    val myUid = FBAuth.getUid()
                    val writerUid = dataModel.uid

                    if(myUid.equals(writerUid)) {
                        Toast.makeText(baseContext, "내가 글쓴이임", Toast.LENGTH_LONG).show()
                        binding.boardSettingIcon.isVisible = true
                    } else {
//                        Toast.makeText(baseContext, "내가 쓴 글 아님 ", Toast.LENGTH_LONG).show()

                    }

                } catch (e: Exception){
                    Log.d(TAG, "삭제완료")
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "LoadPost:onCanceled", databaseError.toException())
            }
        }
        FBRef.boardRef.child(key).addValueEventListener(postListener)
    }
}