package com.example.animation2.shop

import com.example.animation2.R

class Store {
    companion object {
        val products = mutableListOf(
            Product(1,"Пицца - Пеперони",750, R.drawable.pizza_peperony),
            Product(2,"Пицца - Мясная",720, R.drawable.pizza_meat),
            Product(3,"Пицца - Цезарь",780, R.drawable.pizza_cezar),
            Product(4,"Пицца - Грибная",730, R.drawable.pizza_mushrooms),
            Product(5,"Пицца - 4 сыра",710, R.drawable.pizza_4_chees),
            Product(6,"Пицца - Франческа",760, R.drawable.pizza_francheska),
            Product(7,"Напиток - Добрый Кола 0.5л",110, R.drawable.dobriy_cola),
            Product(8,"Напиток - Добрый Лайм 0.5л",110, R.drawable.dobriy_lime),
            Product(9,"Напиток - Добрый Апельсин 0.5л",110, R.drawable.dobriy_orange)
        )
    }

    fun getProducts():MutableList<Product>{
        return products
    }
}