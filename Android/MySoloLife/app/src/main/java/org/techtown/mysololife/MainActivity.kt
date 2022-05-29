package org.techtown.mysololife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.techtown.mysololife.auth.IntroActivity
import org.techtown.mysololife.setting.SettingActivity

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.settingBtn).setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }

        //로그아웃
//        findViewById<Button>(R.id.logoutBtn).setOnClickListener {
//            auth.signOut()
//
//            val intent = Intent(this, IntroActivity::class.java)
////            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
//
//            startActivity(intent)
//        }


    }
}