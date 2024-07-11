package com.dicoding.submissionakhirvgetables

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(private val listVegetables : ArrayList<Vegetables>) : RecyclerView.Adapter<RvAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgVegetable: ImageView = itemView.findViewById(R.id.img_vegetables_photo)
        val vegetableName: TextView = itemView.findViewById(R.id.tv_vegetable_name)
        val vegetablesLatinName : TextView = itemView.findViewById(R.id.tv_vegetable_latinName)
        val vegetableNutrition : TextView = itemView.findViewById(R.id.tv_vegetable_nutrition)
        val vegetableDescription: TextView = itemView.findViewById(R.id.tv_vegetable_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.vegetables_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  listVegetables.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,latinName,nutrition, description, photo) = listVegetables[position]
        holder.imgVegetable.setImageResource(photo)
        holder.vegetableName.text = name
        holder.vegetablesLatinName.text = latinName
        holder.vegetableNutrition.text = nutrition
        holder.vegetableDescription.text = description.substring(0,100) + "..."
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listVegetables[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listVegetables[holder.adapterPosition]) }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Vegetables)
    }


}