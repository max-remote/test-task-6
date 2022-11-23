package com.maxmesh.maxtask6.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContactEntity(
    val id: Int,
    val avatarUrl: String,
    val firstName: String,
    val surname: String,
    val phoneNumber: String
):Parcelable
