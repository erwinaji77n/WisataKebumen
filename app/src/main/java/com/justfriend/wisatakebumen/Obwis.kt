package com.justfriend.wisatakebumen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener



class Obwis : Fragment() {
    lateinit var carouselView: CarouselView
    val sampleImages= intArrayOf(R.drawable.kebumen,R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5,R.drawable.image_6,R.drawable.image_7)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getActivity()?.setTitle("Wisata Kebumen");
        val view: View
        view = inflater.inflate(R.layout.activity_obwis,null)
        carouselView=view.findViewById(R.id.carouselView)
        carouselView.setPageCount(8)
        carouselView.setImageListener(imageListener)
        return view
    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            Glide.with(this@Obwis).load(sampleImages[position]).into(imageView)
        }
    }

}
