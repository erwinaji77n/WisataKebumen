package com.justfriend.wisatakebumen

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.PermissionListener




class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        requestLocationPermission()
        fm=supportFragmentManager
        ft=fm.beginTransaction()
        ft.replace(R.id.container_layout,Home()).commit()
        nav_view
            .menu.getItem(0).isChecked=true

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, Home()).commit()
            }
            R.id.nav_profil->{
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, Obwis()).commit()
            }
            R.id.nav_portal -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, WebWisata()).commit()
            }

            R.id.nav_lokasi -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, PetaKebumen()).commit()
            }
            R.id.nav_video -> {
                var i: Intent
                i= Intent(this@MainActivity,VideoWisata::class.java)
                startActivity(i)
            }
            R.id.nav_galeri -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, GaleriWisata()).commit()
            }
            R.id.nav_about -> {
                fm=supportFragmentManager
                ft=fm.beginTransaction()
                ft.replace(R.id.container_layout, Profile()).commit()
            }
            R.id.nav_keluar -> {
                AlertDialog.Builder(this@MainActivity)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Keluar Dari Aplikasi")
                    .setMessage("Apakah Anda Ingin Keluar Dari Aplikasi?")
                    .setPositiveButton("Ya", { dialog, which -> finish() })
                    .setNegativeButton("Tidak", null)
                    .show()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun requestLocationPermission() {
        Dexter.withActivity(this)
            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {

                    if (response.isPermanentlyDenied) {
                        val intent = Intent(
                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.fromParts("package", packageName, null)
                        )
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }
                }

                override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {
                    token.continuePermissionRequest()
                }
            }).check()
    }

}
