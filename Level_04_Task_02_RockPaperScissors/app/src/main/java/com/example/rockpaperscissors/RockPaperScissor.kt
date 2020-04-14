package com.example.rockpaperscissors

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Game history data in the database
@Entity(tableName="history_table")
data class RockPaperScissor (

    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name = "id")
    var id: Long? = null,

    @ColumnInfo(name = "winner")
    var winner: String,

    @ColumnInfo(name = "computerchoice")
    var computerChoice: Int,

    @ColumnInfo(name = "playerchoice")
    var playerChoice: Int,

    @ColumnInfo(name = "date")
    var date: String
)