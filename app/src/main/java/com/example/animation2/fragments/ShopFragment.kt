package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animation2.CustomAdapter
import com.example.animation2.shop.Product
import com.example.animation2.R
import com.example.animation2.shop.ShopActivity
import com.example.animation2.shop.Store

class ShopFragment : Fragment() {

    private lateinit var recyclerRV:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerRV = view.findViewById(R.id.recyclerRV)
        reInitAdapter()
    }

    private fun reInitAdapter(){
        recyclerRV.layoutManager = LinearLayoutManager(this.context)
        val adapter = CustomAdapter(Store().getProducts())
        recyclerRV.adapter = adapter
        recyclerRV.setHasFixedSize(true)
        adapter.setOnItemClickListener(object:
            CustomAdapter.OnItemClickListener {
            override fun onItemClick(product: Product, position: Int) {
                ShopActivity().shopCart.addProductInCart(product)
                Toast.makeText(activity,"Покупка добавлена - ${product.name}",Toast.LENGTH_SHORT).show()
            }
        })
    }

}