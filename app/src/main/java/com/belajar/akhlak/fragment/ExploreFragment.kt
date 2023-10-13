package com.belajar.akhlak.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.belajar.akhlak.Akhlak
import com.belajar.akhlak.AkhlakAdapter
import com.belajar.akhlak.DetailAkhlak
import com.belajar.akhlak.R

class ExploreFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: AkhlakAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var akhlakArrayList: ArrayList<Akhlak>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>
    lateinit var kunci: Array<String>
    lateinit var panduan: Array<String>
    lateinit var contoh: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_akhlak)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AkhlakAdapter(akhlakArrayList){
            val intent = Intent(context,DetailAkhlak::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
    private fun dataInitialize() {
        akhlakArrayList = arrayListOf<Akhlak>()

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
        descriptions = arrayOf(
            "Kami memegang teguh kepercayaan yang diberikan.",
            "Kami terus belajar dan mengembangkan kapabilitas.",
            "Kami saling peduli dan menghargai perbedaan.",
            "Kami berdedikasi dan mengutamakan kepentingan Bangsa dan Negara.",
            "Kami terus berinovasi dan antusias dalam menggerakkan ataupun menghadapi perubahan.",
            "Kami membangun kerja sama yang sinergis."
        )
        kunci = arrayOf(
            "Integritas, Tulus, Konsisten, Dapat dipercaya.",
            "Kinerja Terbaik, Sukses, Keberhasilan, Learning agility, Ahli di bidangnya.",
            "Peduli (Caring), Keberagaman (Diversity)",
            "Komitmen, Dedikasi (rela berkorban), Kontribusi.",
            "Inovasi, Antusias terhadap perubahan, Proaktif.",
            "Kesediaan bekerjasama, Sinergi untuk hasil yang lebih baik."
        )
        panduan = arrayOf(
            "+ Berperilaku dan bertindak selaras dengan perkataan.\n\n" +
            "+ Menjadi seseorang yang dapat dipercaya dan bertanggung jawab.\n\n" +
            "+ Bertindak jujur dan berpegang teguh kepada nilai moral dan etika secara konsisten\n",

            "+ Terus-menerus meningkatkan kemampuan/kompetensi agar selalu mutakhir\n\n" +
            "+ Selalu dapat diandalkan dengan memberikan kinerja terbaik.\n\n" +
            "+ Menghasilkan kinerja dan prestasi yang memuaskan.\n",

            "+ Berperilaku saling membantu dan mendukung sesama insan organisasi maupun masyarakat.\n\n" +
            "+ Selalu menghargai pendapat, ide atau gagasan orang lain.\n\n" +
            "+ Menghargai kontribusi setiap orang dari berbagai latar belakang.\n",

            "+ Menunjukkan komitmen yang kuat untuk mencapai tujuan.\n\n" +
            "+ Bersedia berkontribusi lebih dan rela berkorban dalam mencapai tujuan.\n\n" +
            "+ Menunjukkan kepatuhan kepada organisasi dan negara.\n",

            "+ Melakukan inovasi secara konsisten untuk menghasilkan yang lebih baik.\n\n" +
            "+ Terbuka terhadap perubahan, bergerak lincah, cepat dan aktif dalam setiap perubahan untuk menjadi lebih baik.\n\n" +
            "+ Bertindak proaktif dalam menggerakan perubahan.\n",

            "+ Terbuka bekerja sama dengan berbagai pihak.\n\n" +
            "+ Mendorong terjadinya sinergi untuk mendapatkan manfaat dan nilai tambah.\n\n" +
            "+ Bersinergi untuk mencapai tujuan bersama.\n"
        )

        contoh = arrayOf(
            "1. Menjaga kerahasiaan data dan informasi perusahaan dan tidak menyampaikan kepada orang yang tidak berhak.\n\n" +
            "2. Mentaati/patuh terhadap setiap kebijakan, prosedur kerja, dan peraturan yang berlaku.\n\n" +
            "3. Berkomitmen terhadap tugas sesuai dengan peran, tanggung jawab, dan kewenangannya.\n\n" +
            "4. Pimpinan dapat menjadi role model/panutan bagi anak buah maupun lingkungan kerjanya.\n\n",

            "1. Memiliki kemauan untuk belajar secara terus menerus untuk meningkatkan keterampilan dan pengetahuan yang dibutuhkan untuk mendukung kelancaran pekerjaannya maupun mengantisipasi tantangan perubahan yang akan terjadi.\n\n" +
            "2. Bersedia untuk mengajarkan pengetahuan atau keterampilan yang dimiliki kepada orang lain.\n\n" +
            "3. Memberikan pelayanan maksimal kepada pelanggan dan selalu mengevaluasi untuk memenuhi kualitas yang terbaik secara berkesinambungan.\n\n" +
            "4. Menyelesaikan setiap pekerjaan sesuai dengan target dan standar mutu yang ditetapkan.\n\n",

            "1. Memberikan kesempatan yang sama serta bersikap adil kepada setiap karyawan.\n\n" +
            "2. Membantu rekan kerja yang membutuhkan.\n\n" +
            "3. Membangun komunikasi yang lebih terbuka dan menjaga hubungan baik dengan stakeholder.\n\n",

            "1. Mengutamakan kepentingan perusahaan, bangsa, dan negara diatas kepentingan pribadi atau kelompok.\n\n" +
            "2. Berani menyampaikan adanya indikasi/hal-hal yang dapat merugikan dan membahayakan perusahaan/negara.\n\n" +
            "3. Melaksanakan instruksi atau tugas dari atasan dengan sungguh-sungguh dan penuh tanggung jawab.\n\n",

            "1. Mencoba menerapkan ide-ide atau gagasan baru yang kreatif untuk mendapatkan metode, proses, dan solusi yang lebih baik.\n\n" +
            "2. Mengimplementasikan perkembangan teknologi untuk memperbaiki metode dan proses kerja, mempercepat monitoring dan analisa data guna mendukung peningkatan kualitas dan kinerja.\n\n",

            "1. Aktif berpartisipasi dan berkontribusi sesuai keahliannya.\n\n" +
            "2. Memberikan kesempatan kepada setiap anggota untuk menyampaikan ide atau gagasan yang produktif.\n\n" +
            "3. Mampu mengelola dan melibatkan seluruh pihak sesuai dengan peran dan fungsinya untuk mencapai tujuan bersama.\n\n"
        )


        for (i in image.indices) {

            val akhlak = Akhlak(image[i], title[i], descriptions[i], kunci[i], panduan[i], contoh[i])
            akhlakArrayList.add(akhlak)
        }
    }
}