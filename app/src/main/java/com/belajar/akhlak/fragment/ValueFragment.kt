package com.belajar.akhlak.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belajar.akhlak.*

class ValueFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: ValueAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var valueArrayList: ArrayList<Values>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var isi: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_value, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_value)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ValueAdapter(valueArrayList){
            val intent = Intent(context,DetailValue::class.java)
            intent.putExtra(ValueFragment.INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        valueArrayList = arrayListOf<Values>()

        image = arrayOf(
            R.drawable.amanah,
            R.drawable.kompeten,
            R.drawable.harmonis,
            R.drawable.loyal,
            R.drawable.adaptif,
            R.drawable.kolaboratif

        )
        title = arrayOf(
            getString(R.string.amanah),
            getString(R.string.kompeten),
            getString(R.string.harmonis),
            getString(R.string.loyal),
            getString(R.string.adaptif),
            getString(R.string.kolaboratif)
        )
        isi = arrayOf(
            "Digambarkan dengan perbaduan garis lengkung dan tangan yang membentuk hati dengan posisi tangan seolah memegang dada kiri " +
            "pada sebuah ikrar/janji, memberi arti memegang teguh kepercayaan " +
            "yang diberikan dengan sepenuh hati.\n",

            "Digambarkan dengan check list dan enam lingkaran yang berarti 6 " +
            "unsur kompetensi yang harus dimiliki yaitu knowledge, skill, attitude, " +
            "experience, responsibility dan accountability.\n",

            "Digambarkan dengan dua buah tangan dalam posisi di atas dan di " +
            "bawah dengan ukuran berbeda, memberi arti saling peduli dan " +
            "saling menghargai pada setiap perbedaan.",

            "Digambarkan dengan sebuah tangan memberi dan hati, memberi " +
            "arti berkontribusi lebih dan rela berkorban dengan sepenuh hati " +
            "untuk kepentingan Bangsa dan Negara.",

            "Digambarkan dengan kepala/otak manusia dan lampu menyala, " +
            "memberi arti aktif berinovasi dengan melahirkan ide-ide baru juga " +
            "solusi yang dapat diterapkan.",

            "Digambarkan dengan beberapa figur manusia dilihat dari atas " +
            "sambil bahu membahu dan sebuah diamond, memberi arti " +
            "pentingnya membangun manfaat dan nilai tambah guna mencapai " +
            "tujuan bersama.\n"
        )


        for (i in image.indices) {

            val value = Values(image[i], title[i], isi[i])
            valueArrayList.add(value)
        }
    }
}