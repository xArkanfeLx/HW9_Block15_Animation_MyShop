package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.animation2.R
import com.example.animation2.shop.ShopActivity


class PurchaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_purchase, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val purchaseTV:TextView = view.findViewById(R.id.purchaseTV)
        val priceTV:TextView = view.findViewById(R.id.priceTV)

        val purchase = ShopActivity().shopCart.getProducts()
        if(purchase.isNotEmpty()) {
            var purchaseText =""
            var price = 0
            for (i in purchase.indices) {
                purchaseText += "${i+1}: ${purchase[i].name} - ${purchase[i].price}x${purchase[i].count}"
                price+=purchase[i].price*purchase[i].count
                if(i+1<purchase.size) purchaseText+="\n\n"
            }
            purchaseTV.text = purchaseText
            priceTV.text = "Всего к оплате: $price руб."

        } else {
            purchaseTV.text = "Нет покупок"
            priceTV.text = "Всего к оплате: 0 руб."
        }
    }
}