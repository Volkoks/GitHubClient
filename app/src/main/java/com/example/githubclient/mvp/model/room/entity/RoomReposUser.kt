package com.example.githubclient.mvp.model.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RoomUser::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class RoomReposUser(
    @PrimaryKey
    var id: String,
    @ColumnInfo
    var name: String,
    @ColumnInfo
    var forks: Int,
    @ColumnInfo
    var description: String,
    @ColumnInfo
    var userId: String
) {
}