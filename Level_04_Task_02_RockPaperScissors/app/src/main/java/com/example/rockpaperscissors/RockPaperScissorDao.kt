package com.example.rockpaperscissors

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//Data Access Object
@Dao
interface RockPaperScissorDao {

    @Query("SELECT * FROM history_table")
    suspend fun getAllGames(): List<RockPaperScissor>

    @Insert
    suspend fun insertGame(rockpaperscissor: RockPaperScissor)

    @Query("DELETE FROM history_table")
    suspend fun deleteAllGames()
}