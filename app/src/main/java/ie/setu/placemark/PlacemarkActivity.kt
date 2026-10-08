package ie.setu.placemark

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ie.setu.placemark.databinding.ActivityPlacemarkBinding
import timber.log.Timber
import timber.log.Timber.i

class PlacemarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacemarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())
        i("Placemark activity started")

        binding.btnAdd.setOnClickListener(){
            val placemarkTitle = binding.placemarkTitle.text.toString()
            if (placemarkTitle.isNotEmpty()){
                i("add button pressed: $placemarkTitle")
            }
            else{
                Toast.makeText(applicationContext, "Please Enter a Title", Toast.LENGTH_LONG).show()
            }
        }


    }
}