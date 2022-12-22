package fastcampus.part3.chapter1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fastcampus.part3.chapter1.databinding.ActivityMainBinding
import fastcampus.part3.face_recognition.Camera

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val camera = Camera(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        camera.initCamera(binding.cameraLayout)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        camera.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}