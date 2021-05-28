package com.example.projet.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R
import com.example.projet.presentation.api.Gamelistresponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val adapter = GameAdapter(listOf(), ::onClickedGame)



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
        recyclerView.apply {
            layoutManager = this@GameListFragment.layoutManager
            adapter = this@GameListFragment.adapter
        }
        Singleton.gameAPI.getGameList("100").enqueue(object : Callback<Gamelistresponse> {
            override fun onFailure(call: Call<Gamelistresponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<Gamelistresponse>,
                response: Response<Gamelistresponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val gameResponse: Gamelistresponse = response.body()!!
                    adapter.updatelist(gameResponse.results)
                }
            }
        })

    }







    private fun onClickedGame(id: Int) {
        findNavController().navigate(R.id.NavigateToGameDetailFragment, bundleOf(
            "GameID" to (id +1)
        ))
    }



}