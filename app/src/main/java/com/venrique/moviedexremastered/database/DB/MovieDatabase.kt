package com.venrique.moviedexremastered.database.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.venrique.moviedexremastered.database.DAO.movieDAO
import com.venrique.moviedexremastered.database.entidades.Movie

@Database(entities = [Movie::class],version = 1,exportSchema = false)
public abstract class MovieDatabase:RoomDatabase(){
    abstract fun movieDao():movieDAO

    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase?=null
        fun getInstance(
            context: Context
        ):MovieDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val  instance=Room
                    .databaseBuilder(context,MovieDatabase::class.java,"Movie Database")
                    .build()
                INSTANCE=instance
                return instance
            }
        }
    }
}