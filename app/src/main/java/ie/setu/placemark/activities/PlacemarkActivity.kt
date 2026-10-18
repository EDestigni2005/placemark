package ie.setu.placemark.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ie.setu.placemark.databinding.ActivityPlacemarkBinding
import ie.setu.placemark.main.MainApp
import ie.setu.placemark.models.PlacemarkModel
import timber.log.Timber
import timber.log.Timber.i

class PlacemarkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlacemarkBinding
    var placemark = PlacemarkModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlacemarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app = application as MainApp
        i("Placemark activity started")

        binding.btnAdd.setOnClickListener{
            placemark.title = binding.placemarkTitle.text.toString()
            placemark.description = binding.placemarkDescription.text.toString()
            if (placemark.title.isNotEmpty() && placemark.description.isNotEmpty()){
                app.placemarks.add(placemark.copy())
                i("add button pressed: $placemark")
                for (i in app.placemarks.indices){
                    i("Placemark[$i}:${this.app.placemarks[i]}")
                }
            }
            else{
                Toast.makeText(applicationContext, "Please Enter a Title", Toast.LENGTH_LONG).show()
            }
        }


    }
}