package com.belajar.akhlak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AkhlakAdapter(private val akhlakList : ArrayList<Akhlak>, val listener: (Akhlak) -> Unit)
    : RecyclerView.Adapter<AkhlakAdapter.AkhlakViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AkhlakViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_akhlak, parent, false)
        return AkhlakViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AkhlakViewHolder, position: Int) {
        holder.bindView(akhlakList[position],listener)

        val currentItem = akhlakList[position]
        holder.imageView.setImageResource(currentItem.imageAkhlak)
        holder.titleAkhlak.text = currentItem.titleAkhlak
        holder.descAkhlak.text = currentItem.descAkhlak
        itemCount
    }

    override fun getItemCount(): Int {
        return akhlakList.size
    }

    class AkhlakViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.iv_img)
        val titleAkhlak : TextView = itemView.findViewById(R.id.tv_title)
        val descAkhlak : TextView = itemView.findViewById(R.id.tv_desc)

        fun bindView(Akhlak: Akhlak, listener: (Akhlak) -> Unit) {
            imageView.setImageResource(Akhlak.imageAkhlak)
            titleAkhlak.text = Akhlak.titleAkhlak
            descAkhlak.text = Akhlak.descAkhlak

            itemView.setOnClickListener{
                listener(Akhlak)
            }
        }
    }
}