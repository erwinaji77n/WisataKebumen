package com.justfriend.wisatakebumen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GaleriWisata : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var lm: RecyclerView.LayoutManager
    lateinit var adapter:GaleriAdapter
    val url= arrayOf("http://indonesiana.tempo.co/uploads/foto/2017/12/29/k-tugulawet.jpg",
        "https://asset.kompas.com/data/photo/2015/10/30/1150271kebumen780x390.jpg",
        "https://cdn.yukepo.com/content-images/main-images/2017/09/11/main_image_11635.jpg",
        "http://mw2.google.com/mw-panoramio/photos/medium/51618953.jpg",
        "http://cdn2.tstatic.net/jateng/foto/bank/images/emandangan-di-puncak-bukit-pentulu-indah-karangsambung-kebumen_20180126_141241.jpg",
        "https://mydailymail.files.wordpress.com/2018/05/pantai-suwuk-dilihat-dari-atas-ketinggian.jpg",
        "https://mydailymail.files.wordpress.com/2018/05/diorama-kisah-raden-kamandaka-atau-lutung-kasarung-di-goa-jatijajar.jpg",
        "https://www.jejakpiknik.com/wp-content/uploads/2018/05/misteri_suasana_mistis_goa-630x380.jpg",
        "https://i0.wp.com/lungadolan.com/wp-content/uploads/2018/04/tempat-wisata-di-gombong-lungadolan.com_.jpg1_.jpg.jpg?w=781&ssl=1",
        "https://ksmtour.com/media/images/articles26/pantai-petanahan-kebumen-jawa-tengah.jpg",
        "https://allesgroen.files.wordpress.com/2017/07/berkuda.jpg",
        "https://asset.kompas.com/crop/0x0:780x390/780x390/data/photo/2018/12/11/1047312665.jpg",
        "https://media-cdn.tripadvisor.com/media/photo-s/0c/74/d2/93/landmark-pentulu-indah.jpg",
        "https://kebudayaan.kemdikbud.go.id/bpcbjateng/wp-content/uploads/sites/31/2016/10/Benteng-van-Der-Wijck.jpg",
        "https://4.bp.blogspot.com/-MT1U6nZtfkA/WFf984QN5MI/AAAAAAAAG3w/alVlHA09xh4lsnbzjeLGq5n8FLBKTqO0gCLcB/s1600/IMG_1017.JPG",
        "https://dolanyok.com/wp-content/uploads/Pantai-Logending-Ayah-Jembatan.jpg",
        "https://cdn-asset.hipwee.com/wp-content/uploads/2017/03/hipwee-Pantai-lampon-kebumen.jpg",
        "https://airebobichon.files.wordpress.com/2017/06/1-explorekebumen-com.jpg",
        "https://www.nativeindonesia.com/wp-content/uploads/2017/08/goa-jatijajar-tempat-wisata-di-kebumen.jpg",
        "https://ksmtour.com/media/images/articles10/goa-jatijajar-jawa-tengah.jpg",
        "http://wonderfulisland.id/wp-content/uploads/2017/03/kebumen.jpg",
        "https://www.bantenshare.com/wp-content/uploads/2017/11/pantai-lampon-di-kebumen-370x215.jpg")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("Galeri Wisata");
        return inflater.inflate(R.layout.activity_galeri_wisata, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView=view.findViewById(R.id.recyclerViewGaleri)
        recyclerView.setHasFixedSize(true)
        lm= GridLayoutManager(context,2)
        recyclerView.layoutManager=lm
        adapter=GaleriAdapter(url,this.context!!)
        recyclerView.adapter=adapter
    }
}
