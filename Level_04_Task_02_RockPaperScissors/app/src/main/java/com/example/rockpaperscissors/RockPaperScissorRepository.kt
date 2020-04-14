package com.example.rockpaperscissors

import android.content.Context

class RockPaperScissorRepository(context: Context) {

    private val rpsDao: RockPaperScissorDao

    init {
        val database = RockPaperScissorRoomDatabase.getDatabase(context)
        rpsDao = database!!.rpsDao()
    }

    suspend fun getAllGames(): List<RockPaperScissor> {
        return rpsDao.getAllGames()
    }

    suspend fun insertGame(rps: RockPaperScissor) {
        rpsDao.insertGame(rps)
    }

    suspend fun deleteAllGames() {
        rpsDao.deleteAllGames()
    }

}