package com.yin.mvvmdemo.model

class News {

    var title: String? = null

    var item_id: String? = null

    var source: String? = null

    override fun toString(): String {
        return "News(title=$title, item_id=$item_id, source=$source)"
    }

}