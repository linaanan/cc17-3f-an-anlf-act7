package com.example.cityapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val categories = listOf(
            Category("Cafes", listOf(
                Place(getString(R.string.cafe_a), R.drawable.cafe_a, getString(R.string.cafe_details_a)),
                Place(getString(R.string.cafe_b), R.drawable.cafe_b, getString(R.string.cafe_details_b)),
                Place(getString(R.string.cafe_c), R.drawable.cafe_c, getString(R.string.cafe_details_c)),
                Place(getString(R.string.cafe_d), R.drawable.cafe_d, getString(R.string.cafe_details_d)),
                Place(getString(R.string.cafe_e), R.drawable.cafe_e, getString(R.string.cafe_details_e))
            ), R.drawable.cafe),

            Category("Churches", listOf(
                Place(getString(R.string.church_a), R.drawable.church_a, getString(R.string.church_details_a)),
                Place(getString(R.string.church_b), R.drawable.church_b, getString(R.string.church_details_b)),
                Place(getString(R.string.church_c), R.drawable.church_c, getString(R.string.church_details_c)),
                Place(getString(R.string.church_d), R.drawable.church_d, getString(R.string.church_details_d)),
                Place(getString(R.string.church_e), R.drawable.church_e, getString(R.string.church_details_e))
            ), R.drawable.church)
        )

        recyclerView.adapter = CategoryAdapter(categories) { category ->
            val action = HomeFragmentDirections.actionHomeFragmentToPlacesFragment(category.places.toTypedArray())
            findNavController().navigate(action)
        }

        requireActivity().title = "Home"

        return view
    }
}
