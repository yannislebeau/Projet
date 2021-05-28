package com.example.projet.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.presentation.api.GameAPI
import com.example.projet.presentation.api.Gameresponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val adapter = GameAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.game_recyclerview)
        recyclerView.layoutManager = this@GameListFragment.layoutManager
        recyclerView.adapter = this@GameListFragment.adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val gameAPI: GameAPI = retrofit.create(GameAPI::class.java)
        gameAPI.getGameList("100").enqueue(object: Callback<Gameresponse>{
            override fun onFailure(call: Call<Gameresponse>, t: Throwable)
            {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<Gameresponse>, response: Response<Gameresponse>)
            {
                if (response.isSuccessful && response.body() != null){
                   val gameResponse: Gameresponse =  response.body()!!
                    adapter.updatelist(gameResponse.results)
                }
            }
        })





    }




}