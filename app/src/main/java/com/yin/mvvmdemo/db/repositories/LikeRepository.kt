package com.yin.mvvmdemo.db.repositories

import com.yin.mvvmdemo.db.dao.LikeDao
import com.yin.mvvmdemo.db.entity.Like
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LikeRepository @Inject constructor(private val likeDao: LikeDao) {

    fun queryLikseByUserId(user_id: Long) = likeDao.queryLikesByUserId(user_id)

    fun insertLike(like: Like) = likeDao.insertLike(like)

    fun deleteLike(like: Like) = likeDao.deleteLikes(like.pd_id, like.user_id)
}