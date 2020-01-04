package com.example.myapplication.mvvm


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.bean.TeacherBean
import com.example.myapplication.utlis.BaseUrl
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.model.Response

/**
 * author: hedianbo.
 * date: 2019-12-30
 * desc:
 */
class TeacherViewModel : ViewModel() {

    internal var mutableLiveData = MutableLiveData<TeacherBean>()


    fun getDatas(teacherId:String) {

        OkGo.get<String>(BaseUrl.baseUrl + "teacher/" + teacherId)
                .execute(object : StringCallback() {
                    override fun onSuccess(response: Response<String>) {
                        Log.e("hedb", "onSuccess: " + response.body())
                        val gson = Gson()
                        val teacherBean = gson.fromJson<TeacherBean>(response.body(), object : TypeToken<TeacherBean>() {
                        }.type)
                        mutableLiveData.postValue(teacherBean)
                    }
                })

    }

}