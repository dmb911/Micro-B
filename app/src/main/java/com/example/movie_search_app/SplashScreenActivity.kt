package com.example.movie_search_app

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.example.movie_search_app.utils.NetworkHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay

class SplashScreenActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashScreen = findViewById<RelativeLayout>(R.id.splash_screen)
        val splashIcon = findViewById<ImageView>(R.id.splash_icon)
        splashIcon.alpha = 0f
        splashIcon.animate().setDuration(1500).alpha(1f).withEndAction() {

            // Check Network Connection

            if (NetworkHelper.isNetworkConnected(this@SplashScreenActivity)){
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }else {
                Snackbar.make(splashScreen, getString(R.string.no_network_connection), Snackbar.LENGTH_LONG
                ).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }

            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()

        }
    }
}

