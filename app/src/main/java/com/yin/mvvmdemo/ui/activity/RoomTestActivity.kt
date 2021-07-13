package com.yin.mvvmdemo.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yin.mvvmdemo.R
import com.yin.mvvmdemo.databinding.ActivityRoomTestBinding
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.Product

class RoomTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityRoomTestBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_room_test)
    }

    var delProductEntity: Product? = null

    fun onclick(view: View) {
//        if (view.id == R.id.btn_add) {
//            Toast.makeText(this, "添加一条数据", Toast.LENGTH_SHORT).show()
//            DataRepository.getInstance()
//                ?.insert(Product(name = "测试商品", price = 99.9, description = "描述"))
//        } else if (view.id == R.id.btn_del) {
//            Toast.makeText(this, "删除一条数据", Toast.LENGTH_SHORT).show()
//            delProductEntity?.let {
//                DataRepository.getInstance()
//                    ?.deleteProducts(it)
//            }
//        } else if (view.id == R.id.btn_update) {
//            delProductEntity?.let {
//                delProductEntity!!.price = 99.99
//                delProductEntity!!.description = "苏大强描述"
//                delProductEntity!!.name = "苏大强"
//                DataRepository.getInstance()
//                    ?.updateProducts(it)
//            }
//            Toast.makeText(this, "更新一条数据", Toast.LENGTH_SHORT).show()
//
//        } else if (view.id == R.id.btn_query) {
//            Toast.makeText(this, "读取一条数据", Toast.LENGTH_SHORT).show()
//            val data = DataRepository.getInstance()?.queryProduct()
//
//        }
    }
}