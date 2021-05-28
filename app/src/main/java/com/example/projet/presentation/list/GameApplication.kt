package com.example.projet.presentation.list

import android.app.Application
import android.content.Context

class GameApplication : Application(){
    companion object{
         var context: Context? = null
    }

    fun OnCreate(){
        super.onCreate()
        context =this
    }
}
