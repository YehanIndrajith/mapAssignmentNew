package com.example.mobile.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobile.R
import com.example.mobile.mapData.Location
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->


        val locationData = arguments?.getParcelable<Location>("location")
        if (locationData?.lat != null && locationData.name != null) {
            val location = LatLng(locationData.lat, locationData.lng)
            googleMap.addMarker(
                com.google.android.gms.maps.model.MarkerOptions().position(location).title("Marker in  $locationData.name ")
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        } else {

            val location = LatLng(-34.0, 151.0)
            googleMap.addMarker(com.google.android.gms.maps.model.MarkerOptions().position(location).title("Marker in Sydney "))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        }
    }


 //   override fun onCreateView(
  //      inflater: LayoutInflater,
   //     container: ,
    //    savedInstanceState: Bundle?
  //  ): View? {
   //     return inflater.inflate(R.layout.fragment_maps, container, false)
   // }

   // override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    //    super.onViewCreated(view, savedInstanceState)
     //   val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
    //    mapFragment?.getMapAsync(callback)
  //  }
//}




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}