package com.justfriend.wisatakebumen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.LatLngBounds




class PetaKebumen : Fragment(), OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener, GoogleMap.OnMarkerClickListener {
    lateinit var pantai_menganti: LatLng
    lateinit var tugu_lawet:LatLng
    lateinit var pentulu_indah:LatLng
    lateinit var goa_jatijajar:LatLng
    lateinit var goa_barat:LatLng
    lateinit var pantai_logending:LatLng
    lateinit var benteng_gombong:LatLng
    lateinit var pantai_suwuk:LatLng
    lateinit var sempor:LatLng
    lateinit var jembangan:LatLng
    lateinit var curug:LatLng
    override fun onMarkerClick(p0: Marker?): Boolean {
        val lokasi = p0?.getTitle()
        if(lokasi.equals("Pantai Menganti")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Pantai Menganti")
            intent?.putExtra("URL", "https://goo.gl/maps/A8ePoaKZAtH2")
            intent?.putExtra("Detail", getString(R.string.pantai_menganti))
            startActivity(intent)
        }else if(lokasi.equals("Tugu Lawet")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Tugu Lawet")
            intent?.putExtra("URL", "https://goo.gl/maps/1nNKMBsyee92")
            intent?.putExtra("Detail", getString(R.string.tugu_lawet))
            startActivity(intent)
        }else if(lokasi.equals("Pentulu Indah")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Pentulu Indah")
            intent?.putExtra("URL", "https://goo.gl/maps/62noxvGx2EH2")
            intent?.putExtra("Detail", getString(R.string.pentulu_indah))
            startActivity(intent)
        }else if(lokasi.equals("Goa Jatijajar")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Goa Jatijajar")
            intent?.putExtra("URL", "https://goo.gl/maps/JBGdRwvddyK2")
            intent?.putExtra("Detail", getString(R.string.goa_jatijajar))
            startActivity(intent)
        }else if(lokasi.equals("Goa Barat")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Goa Barat")
            intent?.putExtra("URL", "https://goo.gl/maps/EaHS63SAT1G2")
            intent?.putExtra("Detail", getString(R.string.goa_barat))
            startActivity(intent)
        }else if(lokasi.equals("Pantai Logending")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Pantai Logending")
            intent?.putExtra("URL", "https://goo.gl/maps/VTsgc3J93LS2")
            intent?.putExtra("Detail", getString(R.string.pantai_ayah))
            startActivity(intent)
        }else if(lokasi.equals("Pantai Suwuk")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Pantai Suwuk")
            intent?.putExtra("URL", "https://goo.gl/maps/Sd1uNAvkF3E2")
            intent?.putExtra("Detail", getString(R.string.pantai_suwuk))
            startActivity(intent)
        }else if(lokasi.equals("Benteng Van Der Wijck")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Benteng Van Der Wijck")
            intent?.putExtra("URL", "https://goo.gl/maps/f5zMt4XficJ2")
            intent?.putExtra("Detail", getString(R.string.benteng_gombong))
            startActivity(intent)
        }else if(lokasi.equals("Jembangan")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Jembangan")
            intent?.putExtra("URL", "https://goo.gl/maps/eVh7JrxFpH82")
            intent?.putExtra("Detail", getString(R.string.jwa))
            startActivity(intent)
        }else if(lokasi.equals("Curug Sindaro")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Curug Sindaro")
            intent?.putExtra("URL", "https://goo.gl/maps/eBv7ivLMBKM2")
            intent?.putExtra("Detail", getString(R.string.curug))
            startActivity(intent)
        }else if(lokasi.equals("Waduk Sempor")){
            val intent = Intent(getActivity(),DetailObwis::class.java)
            intent?.putExtra("Title", "Waduk Sempor")
            intent?.putExtra("URL", "https://goo.gl/maps/WTQaR4kJskH2")
            intent?.putExtra("Detail", getString(R.string.sempor))
            startActivity(intent)
        }else{}
        return true
    }

    override fun onMyLocationClick(p0: Location) {

    }

    override fun onMyLocationButtonClick(): Boolean {
        return false
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_Normal->{
                map.mapType= GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.button_Satellite->{
                map.mapType= GoogleMap.MAP_TYPE_HYBRID
            }
        }
    }

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment
    lateinit var normal: Button
    lateinit var satellite: Button
    @SuppressLint("MissingPermission")
    override fun onMapReady(p0: GoogleMap?) {
        map=p0!!
        val permission = this.context?.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION)
        }

        if (permission == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
            map.setOnMyLocationButtonClickListener(this);
            map.setOnMyLocationClickListener(this);
            map.uiSettings.setZoomControlsEnabled(true);
        }
        curug= LatLng(-7.559110, 109.726400)
        map.addMarker(MarkerOptions().position(curug).title("Curug Sindaro"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(curug,10F))

        jembangan= LatLng(-7.654608, 109.770374)
        map.addMarker(MarkerOptions().position(jembangan).title("Jembangan"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(jembangan,10F))

        sempor= LatLng(-7.560362, 109.485089)
        map.addMarker(MarkerOptions().position(sempor).title("Waduk Sempor"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sempor,10F))

        pantai_menganti= LatLng(-7.770181, 109.413023)
        map.addMarker(MarkerOptions().position(pantai_menganti).title("Pantai Menganti"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_menganti,10F))

        tugu_lawet= LatLng(-7.670917, 109.660838)
        map.addMarker(MarkerOptions().position(tugu_lawet).title("Tugu Lawet"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tugu_lawet,10F))

        pentulu_indah= LatLng(-7.536018, 109.680097)
        map.addMarker(MarkerOptions().position(pentulu_indah).title("Pentulu Indah"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pentulu_indah,10F))

        goa_jatijajar= LatLng(-7.668303, 109.426248)
        map.addMarker(MarkerOptions().position(goa_jatijajar).title("Goa Jatijajar"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(goa_jatijajar,10F))

        goa_barat= LatLng(-7.665484, 109.435925)
        map.addMarker(MarkerOptions().position(goa_barat).title("Goa Barat"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(goa_barat,10F))

        pantai_logending= LatLng(-7.725484, 109.394316)
        map.addMarker(MarkerOptions().position(pantai_logending).title("Pantai Logending"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_logending,10F))

        benteng_gombong= LatLng(-7.599416, 109.517579)
        map.addMarker(MarkerOptions().position(benteng_gombong).title("Benteng Van Der Wijck"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(benteng_gombong,10F))

        pantai_suwuk= LatLng(-7.758646, 109.470034)
        map.addMarker(MarkerOptions().position(pantai_suwuk).title("Pantai Suwuk"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pantai_suwuk,10F))


        val builder = LatLngBounds.Builder()
        builder.include(pantai_menganti)
        builder.include(tugu_lawet)
        builder.include(benteng_gombong)
        builder.include(pantai_suwuk)
        builder.include(pantai_logending)
        builder.include(goa_barat)
        builder.include(goa_jatijajar)
        builder.include(sempor)
        builder.include(jembangan)
        builder.include(curug)
        builder.include(pentulu_indah)
        val bounds = builder.build()
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 20))

        map.setOnMarkerClickListener(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("Peta Wisata");
        return inflater.inflate(R.layout.activity_peta_kebumen,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mp= childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)
        normal=view.findViewById(R.id.button_Normal)
        satellite=view.findViewById(R.id.button_Satellite)

        normal.setOnClickListener(this)
        satellite.setOnClickListener(this)
    }

}

