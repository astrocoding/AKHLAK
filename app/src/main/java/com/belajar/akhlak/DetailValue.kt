package com.belajar.akhlak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.belajar.akhlak.fragment.ExploreFragment
import com.belajar.akhlak.fragment.ValueFragment

class DetailValue : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_value)

        supportActionBar?.title = "Makna AKHLAK"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Values = intent.getParcelableExtra<Values>(ValueFragment.INTENT_PARCELABLE)

        val imageValue = findViewById<ImageView>(R.id.img_item_photo)
        val titleValue = findViewById<TextView>(R.id.tv_item_name)
        val isi = findViewById<TextView>(R.id.tv_item_description)


        imageValue.setImageResource((Values?.imageValue!!))
        titleValue.text = Values.titleValue
        isi.text = Values.isi

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}