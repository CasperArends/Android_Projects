package com.example.rockpaperscissors

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RockPaperScissor::class], version = 1, exportSchema = false)
abstract class RockPaperScissorRoomDatabase : RoomDatabase(){
    abstract fun rpsDao() : RockPaperScissorDao

    companion object{

        private const val DATABASE_NAME = "GAMEHISTORY"

        @Volatile
        private var rpsInstance : RockPaperScissorRoomDatabase? = null

        fun getDatabase(context: Context) : RockPaperScissorRoomDatabase? {
            if (rpsInstance == null){
                synchronized(RockPaperScissorRoomDatabase::class.java){
                    if (rpsInstance == null){
                        rpsInstance = Room.databaseBuilder(context.applicationContext, RockPaperScissorRoomDatabase::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }
            return rpsInstance
        }
    }

}