package com.example.projet.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.loader.app.LoaderManager
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet.R

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


        val gamelist: ArrayList<Game> = arrayListOf<Game>().apply {
            add(Game( "bleu"))
            add(Game( "rouge"))
            add(Game( "vert"))
        }
        adapter.updatelist(gamelist)
    }




}