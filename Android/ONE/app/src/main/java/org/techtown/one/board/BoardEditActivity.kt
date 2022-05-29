package org.techtown.one.board

import android.os.Bundle
import android.os.PersistableBundle
import android.os.health.UidHealthStats
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import org.techtown.one.MainActivity
import org.techtown.one.R
import org.techtown.one.databinding.ActivityBoardEditBinding
import org.techtown.one.utils.FBAuth
import org.techtown.one.utils.FBRef
import java.lang.Exception

class BoardEditActivity : AppCompatActivity(){
    private val database = Firebase.database
    var majorRef = database.getReference(MainActivity.major)

    private lateinit var key : String

    private lateinit var binding: ActivityBoardEditBinding

    private val TAG = BoardEditActivity::class.java.simpleName

    private lateinit var writerUid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_board_edit)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_board_edit)

        key = intent.getStringExtra("key").toString()

        getBoardData(key)
        getImageData(key)

        binding.editBtn.setOnClickListener{
            editBoardData(key)
        }
    }

    private fun editBoardData(key : String){
        FBRef.majorRef.child("board")
            .child(key)
            .setValue(
                BoardModel(binding.titleArea.text.toString(),
                    binding.contentArea.text.toString(),
                    writerUid,
                    FBAuth.getTime())
            )

        Toast.makeText(this, "수정완료", Toast.LENGTH_LONG).show()

        finish()
    }


    private fun getImageData(key : String) {
        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference.child(key + ".png")

        // ImageView in your Activity
        val imageViewFromFB = binding.imageArea

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
                val dataModel = dataSnapshot.getValue(BoardModel::class.java)

                binding.titleArea.setText(dataModel?.title)
                binding.contentArea.setText(dataModel?.content)
                writerUid = dataModel!!.uid

            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "LoadPost:onCanceled", databaseError.toException())
            }
        }
        majorRef.child("board").child(key).addValueEventListener(postListener)
    }
}