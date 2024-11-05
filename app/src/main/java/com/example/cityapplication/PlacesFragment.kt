package com.example.cityapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class PlacesFragment : Fragment() {
    private lateinit var places: Array<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = PlacesFragmentArgs.fromBundle(requireArguments())
        places = args.places
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_places, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PlaceAdapter(places) { place ->
            val action = PlacesFragmentDirections.actionPlacesFragmentToDetailFragment(place)
            findNavController().navigate(action)
        }

        requireActivity().title = "List of places"
        return view
    }
}
