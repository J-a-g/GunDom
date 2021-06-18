package com.yin.mvvmdemo.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yin.mvvmdemo.db.dao.ProductDao
import com.yin.mvvmdemo.db.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        Log.w("scj", "赋值单例")
                        instance = Room.databaseBuilder(
                            context,
                            AppDatabase::class.java, "my_database.db"
                        ).allowMainThreadQueries()
                            .addCallback(sRoomDatabaseCallback)
                            .build()
                    }
                }
            }
            Log.w("scj", "instance -->" + instance.hashCode())
            return instance
        }

        private val sRoomDatabaseCallback: RoomDatabase.Callback =
            object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Log.w("scj", "sRoomDatabaseCallback onCreate")

                }
            }
    }


}