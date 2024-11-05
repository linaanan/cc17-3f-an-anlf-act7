// DetailFragment.kt
package com.example.cityapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {
    private lateinit var place: Place

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        place = DetailFragmentArgs.fromBundle(requireArguments()).place
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        view.findViewById<ImageView>(R.id.place_image).setImageResource(place.imageResId)
        view.findViewById<TextView>(R.id.place_details).text = place.details

        requireActivity().title = place.name

        return view
    }
}

