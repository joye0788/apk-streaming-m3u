package com.iptvstreaming.app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.iptvstreaming.app.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Démarrer l'animation
        binding.animatedLogo.animate()
            .scaleX(1.1f)
            .scaleY(1.1f)
            .setDuration(1000)
            .withEndAction {
                binding.animatedLogo.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(1000)
                    .start()
            }
            .start()

        // Naviguer vers MainActivity après 3 secondes
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}
