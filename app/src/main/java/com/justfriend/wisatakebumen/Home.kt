package com.justfriend.wisatakebumen

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageClickListener
import com.synnapps.carouselview.ImageListener
import kotlinx.android.synthetic.main.activity_main.*


class Home : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.button_obwis->{
                activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container_layout, Obwis())?.commit()
                activity?.nav_view
                    ?.menu?.getItem(1)?.isChecked=true
            }
            R.id.button_web->{
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container_layout, WebWisata())?.commit()
                activity?.nav_view
                    ?.menu?.getItem(2)?.isChecked=true
            }
            R.id.button_lokasi->{
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container_layout, PetaKebumen())?.commit()
                activity?.nav_view
                    ?.menu?.getItem(3)?.isChecked=true
            }
            R.id.button_video->{
                var i: Intent
                activity?.nav_view
                    ?.menu?.getItem(4)?.isChecked=true
                i= Intent(activity,VideoWisata::class.java)
                activity?.startActivity(i)
            }
            R.id.button_galeri->{
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container_layout, GaleriWisata())?.commit()
                activity?.nav_view
                    ?.menu?.getItem(5)?.isChecked=true
            }
            R.id.button_tentang->{
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container_layout, Profile())?.commit()
                activity?.nav_view
                    ?.menu?.getItem(6)?.isChecked=true
            }
        }
    }

    lateinit var carouselView: CarouselView
    lateinit var btn_profile: ImageView
    lateinit var btn_portal: ImageView
    lateinit var btn_lokasi: ImageView
    lateinit var btn_video: ImageView
    lateinit var btn_galeri: ImageView
    lateinit var btn_tentang: ImageView
    val sampleImages= intArrayOf(R.drawable.kebumen,R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5,R.drawable.image_6,R.drawable.image_7,R.drawable.jembangan_img,R.drawable.curug,R.drawable.waduksempor)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("Wisata Kebumen");
        val view: View
        view = inflater.inflate(R.layout.activity_home,null)
        carouselView=view.findViewById(R.id.carouselView)
        carouselView.setPageCount(11)
        carouselView.setImageListener(imageListener)
        carouselView.setImageClickListener { position ->
            if (position==0){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Tugu Lawet")
                intent?.putExtra("URL", "https://goo.gl/maps/1nNKMBsyee92")
                intent?.putExtra("Detail", getString(R.string.tugu_lawet))
                startActivity(intent)
            }else if (position==1){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Goa Jatijajar")
                intent?.putExtra("URL", "https://goo.gl/maps/JBGdRwvddyK2")
                intent?.putExtra("Detail", getString(R.string.goa_jatijajar))
                startActivity(intent)
            }else if (position==2){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Goa Barat")
                intent?.putExtra("URL", "https://goo.gl/maps/EaHS63SAT1G2")
                intent?.putExtra("Detail", getString(R.string.goa_barat))
                startActivity(intent)
            }else if (position==3){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Pentulu Indah")
                intent?.putExtra("URL", "https://goo.gl/maps/62noxvGx2EH2")
                intent?.putExtra("Detail", getString(R.string.pentulu_indah))
                startActivity(intent)
            }else if (position==4){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Pantai Menganti")
                intent?.putExtra("URL", "https://goo.gl/maps/A8ePoaKZAtH2")
                intent?.putExtra("Detail", getString(R.string.pantai_menganti))
                startActivity(intent)
            }else if (position==5){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Pantai Suwuk")
                intent?.putExtra("URL", "https://goo.gl/maps/Sd1uNAvkF3E2")
                intent?.putExtra("Detail", getString(R.string.pantai_suwuk))
                startActivity(intent)
            }else if (position==6){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Benteng Van Der Wijck")
                intent?.putExtra("URL", "https://goo.gl/maps/f5zMt4XficJ2")
                intent?.putExtra("Detail", getString(R.string.benteng_gombong))
                startActivity(intent)
            }else if (position==7){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Pantai Logending")
                intent?.putExtra("URL", "https://goo.gl/maps/VTsgc3J93LS2")
                intent?.putExtra("Detail", getString(R.string.pantai_ayah))
                startActivity(intent)
            }else if (position==8){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Jembangan")
                intent?.putExtra("URL", "https://goo.gl/maps/eVh7JrxFpH82")
                intent?.putExtra("Detail", getString(R.string.jwa))
                startActivity(intent)
            }else if (position==9){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Curug Sindaro")
                intent?.putExtra("URL", "https://goo.gl/maps/eBv7ivLMBKM2")
                intent?.putExtra("Detail", getString(R.string.curug))
                startActivity(intent)
            }else if (position==10){
                val intent = Intent(getActivity(),DetailObwis::class.java)
                intent?.putExtra("Title", "Waduk Sempor")
                intent?.putExtra("URL", "https://goo.gl/maps/WTQaR4kJskH2")
                intent?.putExtra("Detail", getString(R.string.sempor))
                startActivity(intent)
            }else{}
        }
        return view
    }


    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@Home).load(sampleImages[position]).into(imageView)
        }
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_profile=view.findViewById(R.id.button_obwis)
        btn_lokasi=view.findViewById(R.id.button_lokasi)
        btn_portal=view.findViewById(R.id.button_web)
        btn_video=view.findViewById(R.id.button_video)
        btn_galeri=view.findViewById(R.id.button_galeri)
        btn_tentang=view.findViewById(R.id.button_tentang)

        btn_profile.setOnClickListener(this)
        btn_lokasi.setOnClickListener(this)
        btn_portal.setOnClickListener(this)
        btn_video.setOnClickListener(this)
        btn_galeri.setOnClickListener(this)
        btn_tentang.setOnClickListener(this)
    }

}
