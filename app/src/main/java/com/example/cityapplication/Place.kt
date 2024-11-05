// Place.kt
package com.example.cityapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val name: String,
    val imageResId: Int,
    val details: String
) : Parcelable
