package ie.setu.placemark.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ie.setu.placemark.databinding.ActivityPlacemarkBinding
import ie.setu.placemark.models.PlacemarkModel
import timber.log.Timber

class PlacemarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacemarkBinding
    var placemark = PlacemarkModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())
        Timber.i("Placemark activity started")

        binding.btnAdd.setOnClickListener{
            placemark.title = binding.placemarkTitle.text.toString()
            if (placemark.title.isNotEmpty()){
                Timber.i("add button pressed: $placemark.title")
            }
            else{
                Toast.makeText(applicationContext, "Please Enter a Title", Toast.LENGTH_LONG).show()
            }
        }


    }
}