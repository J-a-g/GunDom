package com.yin.mvvmdemo.db

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.dao.LikeDao
import com.yin.mvvmdemo.db.dao.ProductDao
import com.yin.mvvmdemo.db.dao.UserDao
import com.yin.mvvmdemo.db.entity.Like
import com.yin.mvvmdemo.db.entity.Product
import com.yin.mvvmdemo.db.entity.User

@Database(entities = arrayOf(Product::class, User::class, Like::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    abstract fun userDao(): UserDao

    abstract fun likeDao(): LikeDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class.java) {
                    if (instance == null) {
                        Log.w("scj", "赋值单例")
                        instance = BasicApp.instance?.let {
                            Room.databaseBuilder(
                                it,
                                AppDatabase::class.java, "my_database.db"
                            ).allowMainThreadQueries()
                                .addCallback(sRoomDatabaseCallback)
                                .build()
                        }
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