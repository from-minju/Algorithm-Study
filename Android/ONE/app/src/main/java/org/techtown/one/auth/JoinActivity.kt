package org.techtown.one.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.techtown.one.MainActivity
import org.techtown.one.R
import org.techtown.one.board.BoardModel
import org.techtown.one.databinding.ActivityJoinBinding
import org.techtown.one.utils.FBAuth
import org.techtown.one.utils.FBRef

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityJoinBinding

    private val TAG = JoinActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_join)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

        binding.joinBtn.setOnClickListener{

            var isGoToJoin = true

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()

            //값이 비어있는지 확인
            if(email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password1.isEmpty()){
                Toast.makeText(this, "Password1을 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(password2.isEmpty()){
                Toast.makeText(this, "Password2를 입력해주세요", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            //비밀번호 2개가 같은지 확인
            if(!password1.equals(password2)){
                Toast.makeText(this, "비밀번호를 똑같이 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            //비밀번호는 6자리가 넘어야함
            if(password1.length < 6) {
                Toast.makeText(this, "비밀번호를 6자리 이상으로 입력해주세요.", Toast.LENGTH_LONG).show()
                isGoToJoin = false
            }

            if(isGoToJoin){
                //신규사용자 가입
                auth.createUserWithEmailAndPassword(email, password1).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //binding = DataBindingUtil.setContentView(this, R.layout.activity_join)

                    val name = binding.userName.text.toString()
                    val studentId = binding.userStudentID.text.toString()
                    val major = binding.userMajor.text.toString()
                    val grade = binding.userGrade.text.toString()
//                    val uid = FBAuth.getUid()

//                    Log.d(TAG, name)
//                    Log.d(TAG, studentId)
//                    Log.d(TAG, major)
//                    Log.d(TAG, grade)


                    //데이터 구
                    //board
                    //  -key
                    //      -boardModel(title, content, uid, time)


//                    FBRef.bookmarkRef.child(FBAuth.getUid()).addValueEventListener(postListener)
//
//                    FBRef.bookmarkRef
//                        .child(FBAuth.getUid())
//                        .child(key)
//                        .setValue(BookmarkModel(true))


                    FBRef.userRef
                        .child(FBAuth.getUid())
                        //.push()
                        .setValue(UserModel(name, studentId, major, grade))


                        //finish()


                    // Sign in success
                    Toast.makeText(this, "회원가입 성공", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, MainActivity::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)

                } else {
                    // If sign in fails
                    Toast.makeText(this, "실패", Toast.LENGTH_LONG).show()
                }


            }

            }
        }

        // Initialize Firebase Auth
        auth = Firebase.auth

//
    }
}