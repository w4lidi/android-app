package com.dicoding.submissionakhirvgetables

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(private val listVegetables : ArrayList<Vegetables>) : RecyclerView.Adapter<RvAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgVegetable: ImageView = itemView.findViewById(R.id.img_vegetables_photo)
        val vegetableName: TextView = itemView.findViewById(R.id.tv_vegetable_name)
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
        val (name, description, photo) = listVegetables[position]
        holder.imgVegetable.setImageResource(photo)
        holder.vegetableName.text = name
        holder.vegetableDescription.text = description
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listVegetables[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listVegetables[holder.adapterPosition]) }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Vegetables)
    }
}