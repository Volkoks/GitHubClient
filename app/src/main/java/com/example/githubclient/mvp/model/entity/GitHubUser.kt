package com.example.githubclient.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    @Expose
    val id:String? = null,
    @Expose
    val login:String? = null,
    @Expose
    val avatarUrl:String? = null
):Parcelable