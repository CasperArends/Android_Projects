package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Link (
    var linkTitle:String,
    var linkAddress:String
): Parcelable