package com.dicoding.submissionakhirvgetables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class MainActivity : AppCompatActivity() {
    private lateinit var rvVegetables: RecyclerView
    private val list = ArrayList<Vegetables>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvVegetables = findViewById(R.id.vegetablesList)
        rvVegetables.setHasFixedSize(true)

        list.addAll(geVegetablestList())
        showRecyclerList()
    }

    private fun geVegetablestList(): ArrayList<Vegetables> {
        val vegetableName = resources.getStringArray(R.array.vegetables_name)
        val vegetablesDescription = resources.getStringArray(R.array.vegetables_description)
        val vegetablesPhoto = resources.obtainTypedArray(R.array.vegetables_image)
        val listHero = ArrayList<Vegetables>()
        for (i in vegetableName.indices) {
            val hero = Vegetables(
                vegetableName[i],
                vegetablesDescription[i],
                vegetablesPhoto.getResourceId(i, -1)

            )
            listHero.add(hero)

        }
        vegetablesPhoto.recycle()
        return listHero

    }

    private fun showRecyclerList() {
        rvVegetables.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = RvAdapter(list)
        rvVegetables.adapter = listHeroAdapter


        listHeroAdapter.setOnItemClickCallback(object : RvAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Vegetables) {
                showSelectedVegetables(data)
            }
        })

    }

    private fun showSelectedVegetables(vegetables: Vegetables) {
        //.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
        val detailActivity = Intent(this@MainActivity, VegetablesDetail::class.java)
        detailActivity.putExtra(VegetablesDetail.EXTRA_NAME, vegetables)
//        intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)

        startActivity(detailActivity)
    }
}