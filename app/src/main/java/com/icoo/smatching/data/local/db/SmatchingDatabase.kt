package com.icoo.smatching.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.icoo.smatching.data.local.db.entity.TestEntity

@Database(entities = [TestEntity::class], version = 2)
abstract class SmatchingDatabase : RoomDatabase() {

    companion object {
        var INSTANCE: SmatchingDatabase? = null

        fun getInstance(context: Context): SmatchingDatabase? {
            if (INSTANCE == null) {
                synchronized(SmatchingDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SmatchingDatabase::class.java,
                        "smatching.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }
    }
}
