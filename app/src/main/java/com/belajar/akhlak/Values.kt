package com.belajar.akhlak

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Values(
    var imageValue: Int,
    var titleValue: String,
    var isi: String,
) : Parcelable