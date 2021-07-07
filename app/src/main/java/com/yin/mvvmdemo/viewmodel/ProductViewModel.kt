package com.yin.mvvmdemo.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.yin.mvvmdemo.BasicApp
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.Like
import com.yin.mvvmdemo.db.entity.Product

class ProductViewModel : ViewModel() {

    var position: Int = 0
    private var topProduct = MutableLiveData<Product?>()

    //    var products = DataRepository.getInstance()?.queryProduct()
    var products: LiveData<List<Product>>? = null
    //DataRepository.getInstance()?.queryProductByUserLikes(BasicApp.currentUser.id) //= DataRepository.getInstance()?.queryProductByUserLikes(BasicApp.currentUser.id)
//    val updateTest: MutableLiveData<Boolean> = MutableLiveData(false)
//    lateinit var products: LiveData<List<Product>>

    init {
//        topProduct.value = DataRepository.getInstance()?.queryTopProduct()
        Log.w("scj", "ProdctViewModel init")
        products = DataRepository.getInstance()?.queryProductByUserLikes(BasicApp.currentUser.user_id)
    }

    fun onclickItem(position: Int) {
        this.position = position
        topProduct.value = products?.value?.get(position)
        Log.w("scj", "onClickItem->" + position + " -- " + topProduct.value.toString())
    }

    fun onInsert() {
        Log.w("scj", "onInsert")
        val pro = Product()
        DataRepository.getInstance()?.insert(pro)
        position = 0
    }

    fun onQuery() {
        val context = BasicApp.instance as Context
        context.assets.open("gundom.json").use {
            JsonReader(it.reader()).use {
                val gundomType = object : TypeToken<List<Product>>() {}.type
                val gundoms: List<Product> = Gson().fromJson(it, gundomType)
                for (gd in gundoms) {
                    Log.w("scj", "gundom : " + gd.toString())
                }
                DataRepository.getInstance()?.insertProducts(gundoms)
            }
        }
    }

    fun onUpdate() {
//        val newList = products?.value?.toMutableList()
//        val pro = newList?.get(position)?.copy()
//        if (pro != null) {
//            Log.w("scj", "修改原来数据 ：" + pro.toString())
//            pro.price = 77.7
//            pro.name = "hello world"
//            newList.removeAt(position)
//            newList.add(position, pro)
//            DataRepository.getInstance()?.updateProducts(pro)
//        }

//        val list = DataRepository.getInstance()?.getUserAndProduct()
//        if (list != null) {
//            for (result in list) {
//                Log.w("scj", "result->" + result.toString())
//            }
//        }

//        val list = DataRepository.getInstance()?.getProductsWithUsers()
//
//        Log.w("scj", "list ->" + list?.size)
//        if(list != null){
//            for(userWith in list){
//                Log.w("scj", "result->" + userWith.toString())
//            }
//        }



        DataRepository.getInstance()?.updateFavoritesProducts(BasicApp.currentUser.user_id)

    }

    fun onLike(position: Int) {
        val newList = products?.value?.toMutableList()
        val pro = newList?.get(position)?.copy()
        if (pro != null) {
            Log.w("scj", "修改原来数据 ：" + pro.toString())

            if (pro.likes == 0) {
                pro.likes = 1

                DataRepository.getInstance()?.insertLike(Like(pro.pd_id, BasicApp.currentUser.user_id))
            } else {
                pro.likes = 0
                DataRepository.getInstance()?.deleteLike(Like(pro.pd_id, BasicApp.currentUser.user_id))
            }

            newList.removeAt(position)
            newList.add(position, pro)
            DataRepository.getInstance()?.updateProducts(pro)
        }
    }
}