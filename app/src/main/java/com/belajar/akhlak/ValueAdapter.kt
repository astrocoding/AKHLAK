package com.belajar.akhlak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ValueAdapter(private val valueList : ArrayList<Values>, val listener: (Values) -> Unit)
    : RecyclerView.Adapter<ValueAdapter.ValueViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ValueViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_value, parent, false)
        return ValueViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ValueViewHolder, position: Int) {
        holder.bindView(valueList[position], listener)

        val currentItem = valueList[position]
        holder.imageView.setImageResource(currentItem.imageValue)
        holder.titleValue.text = currentItem.titleValue
        holder.isi.text = currentItem.isi
        itemCount
    }

    override fun getItemCount(): Int {
        return valueList.size
    }

    class ValueViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.tv_image)
        val titleValue : TextView = itemView.findViewById(R.id.tv_judul)
        val isi : TextView = itemView.findViewById(R.id.tv_isi)

        fun bindView(Values: Values, listener: (Values) -> Unit) {
            imageView.setImageResource(Values.imageValue)
            titleValue.text = Values.titleValue
            isi.text = Values.isi

            itemView.setOnClickListener{
                listener(Values)
            }
        }
    }
}