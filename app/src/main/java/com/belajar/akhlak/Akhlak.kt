package com.belajar.akhlak

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Akhlak(
    var imageAkhlak: Int,
    var titleAkhlak: String,
    var descAkhlak: String,
    var kunci: String,
    var panduan: String,
    var contoh: String
) : Parcelable