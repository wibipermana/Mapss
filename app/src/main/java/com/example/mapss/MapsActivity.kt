package com.example.mapss

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




        val latitude =-7.747033
        val latituderumah = -7.715317
        val latKos = -7.753386
        val longKos = 110.345686
        val longtituderumah = 110.381871
        val longitude =  110.355398
        val zoomLevel =15f
        val overlaySize = 100f

        val homeLatLng = LatLng(latitude,longitude)
        mMap.addMarker(MarkerOptions().position(homeLatLng).title("Universitas Teknologi Yogjakarta").snippet("-7.747033/110.355398"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))

        val rumah = LatLng(latituderumah,longtituderumah)
        mMap.addMarker(MarkerOptions().position(rumah).title("rumah saya").snippet("-7.715317/110.381871").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val kos = LatLng(latKos,longKos)
        mMap.addMarker(MarkerOptions().position(kos).title("Kos Ku").snippet("-7.753386/110.345686").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))


        val googleOverlay= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.uty)).position(homeLatLng,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay3= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.kos)).position(kos,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)

        val googleOverlay2= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.rumah)).position(rumah,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)
    }}
