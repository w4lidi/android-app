package com.dicoding.submissionakhirvgetables

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


import androidx.appcompat.app.AppCompatActivity

class VegetablesDetail : AppCompatActivity(){
    private lateinit var action_share : Button
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.vegetables_detail)



        val vegetablesImg : ImageView = findViewById(R.id.detailVegetablesImage)
        val vegetablesName : TextView = findViewById(R.id.detailVegetablesName)
        val vegetablesDesc : TextView = findViewById(R.id.detailVegetablesDesc)

        action_share = findViewById(R.id.action_share)

//        val objRecv = Intent.getParcelableExtra(EXTRA_NAME, Book::class.java)
//        val objRecv = intent.getParcelableExtra<Vegetables>("extra_name")



        val objRecv = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Vegetables>(EXTRA_NAME, Vegetables::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Vegetables>(EXTRA_NAME)
        }

        Glide.with(this).load(objRecv?.photo).into(vegetablesImg)
        Log.d("GAMBA4", objRecv.toString())


        vegetablesName.text = objRecv?.name.toString()
        vegetablesDesc.text = objRecv?.description.toString()

        action_share.setOnClickListener {
//            val sendIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, objRecv?.description.toString())
//                type = "text/plain"
//            }
//
//            val shareIntent = Intent.createChooser(sendIntent, null)
//            startActivity(shareIntent)

            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                // Example: content://com.google.android.apps.photos.contentprovider/...

                putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.dicoding.submissionakhirvgetables/"+R.drawable.brokoli))

                type = "image/png"
//
            }
            startActivity(Intent.createChooser(shareIntent, "brokoli"))

        }


    }

    companion object {
        val EXTRA_NAME: String = "extra_name"
    }
}

