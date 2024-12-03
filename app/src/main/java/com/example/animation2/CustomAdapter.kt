package com.example.animation2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.animation2.shop.Product

class CustomAdapter(private val products: MutableList<Product>) :
    RecyclerView.Adapter<CustomAdapter.ItemViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(product: Product, position: Int)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIV: ImageView = itemView.findViewById(R.id.imgIV)
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
        val priceTV: TextView = itemView.findViewById(R.id.priceTV)
        val countLL: LinearLayout = itemView.findViewById(R.id.countLL)
        val quantityTV: TextView = itemView.findViewById(R.id.quantityTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate((R.layout.list_item), parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = products.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = products[position]
        holder.nameTV.text = item.name
        holder.priceTV.text = "${item.price} руб."
        holder.imgIV.setImageResource(item.img)
        holder.itemView.setOnClickListener {
            if (onItemClickListener != null) {
                onItemClickListener!!.onItemClick(item, position)
            }
        }
        if(item.isShopCart) {
            holder.countLL.visibility = View.VISIBLE
            holder.quantityTV.text = item.count.toString()
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}