package com.example.simple_photo_frame

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.simple_photo_frame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val names= arrayOf("Pain","obito","obito","Kakashi","War","7","Sakura Haruno"," team 7","obito","Team 7","obito","Madara and obito","Uchia","obito","war","Itachi","Madara","Madara","Naruto","Madara","Madara","Madara","Pain")

    lateinit var image: ImageView
    lateinit var binding: ActivityMainBinding
    var currentImage=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imgprevbtn.setOnClickListener {
            val idofcurrentImagestring="pic$currentImage"
        //convert the string id to the integer address associated with it
            val idofcurrentImageInt=this.resources.getIdentifier(idofcurrentImagestring,"id",packageName)
            image=findViewById(idofcurrentImageInt)
            image.alpha=0f

            currentImage=(23+currentImage-1)%23
            val idofImagetoshowString="pic$currentImage"
            val idofcurrenttoshowimageInt=this.resources.getIdentifier(idofImagetoshowString,"id",packageName)
            image=findViewById(idofcurrenttoshowimageInt)
            image.alpha=1f
            binding.textView.text=names[currentImage]
        }
        binding.imgnextbtn.setOnClickListener {
            val idofcurrentimgstring="pic$currentImage"
            val idofcurrentimgint=this.resources.getIdentifier(idofcurrentimgstring,"id",packageName)
            image=findViewById(idofcurrentimgint)
            image.alpha=0f

            currentImage=(23+currentImage+1)%23
            val idofimgtoshow="pic$currentImage"
            val idofcurrentimgtoshowint=this.resources.getIdentifier(idofimgtoshow,"id",packageName)
            image=findViewById(idofcurrentimgtoshowint)
            image.alpha=1f
            binding.textView.text=names[currentImage]
        }
    }
}