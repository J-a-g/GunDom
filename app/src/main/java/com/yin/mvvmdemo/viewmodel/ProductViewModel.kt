package com.yin.mvvmdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yin.mvvmdemo.db.DataRepository
import com.yin.mvvmdemo.db.entity.Product

class ProductViewModel : ViewModel() {

    var position: Int = 0
    private var topProduct = MutableLiveData<Product?>()
    var products = DataRepository.getInstance()?.queryProduct()
//    val updateTest: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
//        topProduct.value = DataRepository.getInstance()?.queryTopProduct()
    }

    fun onclickItem(position : Int){
        this.position = position
        topProduct.value = products?.value?.get(position)
        Log.w("scj", "onClickItem->" + position + " -- " +  topProduct.value.toString())
    }

    fun onInsert() {
        Log.w("scj", "onInsert")
        val pro = Product()
        DataRepository.getInstance()?.insert(pro)

        position = 0
//        topProduct.value = DataRepository.getInstance()?.queryTopProduct()
    }

    fun onQuery() {
        Log.w("scj", "topProduct:" + topProduct.value.toString())
//        DataRepository.getInstance()?.queryProduct()
    }

    fun onUpdate() {
        Log.w("scj", "onUpdate")

        val newList = products?.value?.toMutableList()
        val pro = newList?.get(position)?.copy()

        if (pro != null) {
            Log.w("scj", "修改原来数据 ：" + pro.toString())
            pro.product_price = 77.7
            pro.product_name = "hello world"

            newList.removeAt(position)
            newList.add(position, pro)
            DataRepository.getInstance()?.updateProducts(pro)
        }
    }


}