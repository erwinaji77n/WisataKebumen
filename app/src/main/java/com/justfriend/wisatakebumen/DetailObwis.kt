package com.justfriend.wisatakebumen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.my_toolbar.*

class DetailObwis : AppCompatActivity() {
    lateinit var tv_title:TextView
    lateinit var tv_detail:TextView
    lateinit var iv_gmbr:ImageView
    private var fab: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_obwis)
        setSupportActionBar(tToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        iv_gmbr=findViewById(R.id.iv_gambar) as ImageView
        tv_title=findViewById(R.id.tv_judul)
        tv_detail=findViewById(R.id.tv_penjelasan)
        var t: String = intent.getStringExtra("Title")
        var d: String = intent.getStringExtra("Detail")
        var url: String = intent.getStringExtra("URL")
        supportActionBar?.title =t
        tv_title.setText(t)
        tv_detail.setText(d)
        var a=tv_title.text
        if (a=="Pantai Menganti"){
            iv_gmbr.setImageResource(R.drawable.image_4)
        }else if (a=="Tugu Lawet"){
            iv_gmbr.setImageResource(R.drawable.kebumen)
        }else if (a=="Pentulu Indah"){
            iv_gmbr.setImageResource(R.drawable.image_3)
        }else if (a=="Goa Jatijajar"){
            iv_gmbr.setImageResource(R.drawable.image_1)
        }else if (a=="Goa Barat"){
            iv_gmbr.setImageResource(R.drawable.image_2)
        }else if (a=="Pantai Logending"){
            iv_gmbr.setImageResource(R.drawable.image_7)
        }else if (a=="Pantai Suwuk"){
            iv_gmbr.setImageResource(R.drawable.image_5)
        }else if (a=="Benteng Van Der Wijck"){
            iv_gmbr.setImageResource(R.drawable.image_6)
        }else if (a=="Waduk Sempor"){
            iv_gmbr.setImageResource(R.drawable.waduksempor)
        }else if (a=="Jembangan"){
            iv_gmbr.setImageResource(R.drawable.jembangan_img)
        }else if (a=="Curug Sindaro"){
            iv_gmbr.setImageResource(R.drawable.curug)
        }
        else{
            iv_gmbr.setImageResource(R.drawable.kebumen)
        }
        fab = findViewById(R.id.fab) as FloatingActionButton
        fab!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )
                startActivity(intent)
            }
        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
