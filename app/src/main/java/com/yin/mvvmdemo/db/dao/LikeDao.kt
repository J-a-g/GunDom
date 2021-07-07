package com.yin.mvvmdemo.db.dao

import androidx.room.*
import com.yin.mvvmdemo.db.entity.Like
import com.yin.mvvmdemo.db.entity.Product

@Dao
abstract class LikeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLike(like: Like)

    //1.删除数据，根据主键来删除数据的！！！
    @Delete
    abstract fun deleteLike(like: Like)

    @Query("DELETE FROM `like` WHERE pd_id Like :pro_id AND user_id Like :user_id")
    abstract fun deleteLikes(pro_id: Long, user_id: Long)

    @Query("SELECT * FROM `like` WHERE user_id Like :user_id")
    abstract fun queryLikesByUserId(user_id: Long): Array<Like>
}