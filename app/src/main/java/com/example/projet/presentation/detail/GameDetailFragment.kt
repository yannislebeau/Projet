package com.example.projet.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.projet.R
import com.example.projet.presentation.api.Gamedetailresponse
import com.example.projet.presentation.api.Gamelistresponse
import com.example.projet.presentation.list.Singleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GameDetailFragment : Fragment() {

    private lateinit var  textVieweffect: TextView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textVieweffect = view.findViewById(R.id.Gamedetail_effect)
       callAPI()
    }

    private fun callAPI(){
    Singleton.gameAPI.getGameDetail("1").enqueue(object: Callback<Gamedetailresponse>{
        override fun onFailure(call: Call<Gamedetailresponse>, t: Throwable)
        {
            TODO("Not yet implemented")
        }

        override fun onResponse(
            call: Call<Gamedetailresponse>,
            response: Response<Gamedetailresponse>
        ) {
            if (response.isSuccessful && response.body() != null){

                textVieweffect.text =response.body()!!.name

            }
        }

    })
    }
}