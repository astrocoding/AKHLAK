package com.belajar.akhlak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.belajar.akhlak.fragment.ExploreFragment
import org.w3c.dom.Text

class DetailAkhlak : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_akhlak)

        supportActionBar?.title = "Detail AKHLAK"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Akhlak = intent.getParcelableExtra<Akhlak>(ExploreFragment.INTENT_PARCELABLE)

        val imageAkhlak = findViewById<ImageView>(R.id.img_item_photo)
        val titleAkhlak = findViewById<TextView>(R.id.tv_item_name)
        val descAkhlak = findViewById<TextView>(R.id.tv_item_description)
        val kunci = findViewById<TextView>(R. id.tv_item_kunci)
        val panduan = findViewById<TextView>(R.id.tv_item_panduan)
        val contoh = findViewById<TextView>(R.id.tv_item_contoh)

        imageAkhlak.setImageResource(Akhlak?.imageAkhlak!!)
        titleAkhlak.text = Akhlak.titleAkhlak
        descAkhlak.text = Akhlak.descAkhlak
        kunci.text = Akhlak.kunci
        panduan.text = Akhlak.panduan
        contoh.text = Akhlak.contoh
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}