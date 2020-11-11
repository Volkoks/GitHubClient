package com.example.githubclient.mvp.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    var login:String
):Parcelable {
}