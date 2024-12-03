package com.example.animation2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animation2.CustomAdapter
import com.example.animation2.shop.Product
import com.example.animation2.R
import com.example.animation2.shop.ShopActivity

class ShopCartFragment : Fragment() {

    lateinit var recyclerRV:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerRV = view.findViewById(R.id.recyclerRV)
        recyclerRV.layoutManager = LinearLayoutManager(this.context)
        reInitAdapter()
        Toast.makeText(activity,"Перешли в корзину",Toast.LENGTH_SHORT).show()
    }

    private fun reInitAdapter(){
        val adapter = CustomAdapter(ShopActivity().shopCart.getProducts())
        recyclerRV.adapter = adapter
        recyclerRV.setHasFixedSize(true)
        adapter.setOnItemClickListener(object:
            CustomAdapter.OnItemClickListener {
            override fun onItemClick(product: Product, position: Int) {
                val dialog = AlertDialog.Builder(activity!!)

                dialog.setTitle("Удаление позиции")
                dialog.setMessage("Вы уверены?")
                dialog.setPositiveButton("Удалить") { _, _ ->
                    ShopActivity().shopCart.deleteProductInCart(position)
                    reInitAdapter()
                }
                dialog.setNegativeButton("Отмена") { _, _ -> }
                dialog.create().show()
            }
        })
    }

}