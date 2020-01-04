package com.example.myapplication.mvvm


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMvvmKotlinTeacherBinding



class MVVMKotlinTeachDetailActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModelProviders.of(this).get(TeacherViewModel::class.java) }

    private val binding by lazy { DataBindingUtil.setContentView<ActivityMvvmKotlinTeacherBinding>(this, R.layout.activity_mvvm_kotlin_teacher) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("teacherId")

        viewModel.mutableLiveData.observe(this, Observer {
            if (it != null) {
                binding.teacher = it;
            }
        })
        viewModel.getDatas(id);
    }

}