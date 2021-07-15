/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yin.mvvmdemo.data

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt

/**
 * Used as a layout variable to provide static properties (name and lastName) and an observable
 * one (likes).
 */
data class ObservableFieldProfile(
    var name: String,
    val lastName: ObservableField<String>,
    val likes: ObservableInt,
    val url: ObservableField<String>
) {

    fun onCheckName(view :View) {
        lastName.set("孔")
        name = "乙己"
    }

    fun onCheckUrl() {
        Log.w("scj", "onCheckUrl")
        url.set("https://gitee.com/jags/pictures/raw/master/images/img_test2.png")
    }

    fun onLike(view: View) {
        likes.set(likes.get() + 1)
    }

    override fun toString(): String {
        return "ObservableFieldProfile(name='$name', lastName=$lastName, likes=$likes, url=$url)"
    }
}
