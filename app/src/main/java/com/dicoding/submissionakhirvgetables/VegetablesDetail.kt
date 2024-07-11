package com.dicoding.submissionakhirvgetables


import android.content.Intent

import android.os.Build
import android.os.Bundle

import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class VegetablesDetail : AppCompatActivity(){
    private lateinit var actionShare : Button
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.vegetables_detail)



        val vegetablesImg : ImageView = findViewById(R.id.detailVegetablesImage)
        val vegetablesName : TextView = findViewById(R.id.detailVegetablesName)
        val vegetablesLatinName : TextView = findViewById(R.id.detailVegetablesLatinName)
        val vegetablesNutrition : TextView = findViewById(R.id.detailVegetablesNutrition)
        val vegetablesDesc : TextView = findViewById(R.id.detailVegetablesDesc)
        val title : TextView = findViewById(R.id.detail_title)
        val backButton : ImageView = findViewById(R.id.back_button)
        val aboutMe : ImageView = findViewById(R.id.about_Page)
        actionShare = findViewById(R.id.action_share)

//        val objRecv = Intent.getParcelableExtra(EXTRA_NAME, Book::class.java)
//        val objRecv = intent.getParcelableExtra<Vegetables>("extra_name")

        backButton.setOnClickListener{
//            onBackPressed()
            onBackPressedDispatcher.onBackPressed()
        }
        aboutMe.setOnClickListener{
            val moveIntent = Intent(this@VegetablesDetail, AboutMe::class.java)
            startActivity(moveIntent)
        }

        val objRecv = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_NAME, Vegetables::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_NAME)
        }

        Glide.with(this).load(objRecv?.photo).into(vegetablesImg)
        Log.d("GAMBA4", objRecv.toString())

//        title.text = objRecv?.name.toString() + resources.getString(R.string.detail)
        title.text = getString(R.string.title_details, objRecv?.name.toString(), " Detail")
        vegetablesName.text = objRecv?.name.toString()
        vegetablesLatinName.text = objRecv?.latinName.toString()
        vegetablesNutrition.text = objRecv?.nutrition.toString()
        vegetablesDesc.text = objRecv?.description.toString()
        actionShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,
                    "*" + objRecv?.name.toString() +"*\n" +
                          "_" +  objRecv?.latinName.toString() +"_\n" +
                          "_" +  objRecv?.nutrition.toString()+"_\n\n" +
                          "" +  objRecv?.description.toString())
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


//                   val shareIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                // Example: content://com.google.android.apps.photos.contentprovider/...
//                Log.d("gambar",Uri.parse("android.resource://com.dicoding.submissionakhirvgetables/"+R.drawable.brokoli).toString())
//                putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.dicoding.submissionakhirvgetables/"+R.drawable.brokoli))
//
//                type = "image/png"
////
//            }
//            startActivity(Intent.createChooser(shareIntent, "brokoli"))





    }

    companion object {
       const val EXTRA_NAME: String = "extra_name"
    }
}

