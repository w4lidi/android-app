package com.dicoding.submissionakhirvgetables

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vegetables(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
