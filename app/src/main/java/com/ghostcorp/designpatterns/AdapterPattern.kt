package com.ghostcorp.designpatterns

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HamburgerAdapter(private val hamburgers : List<Hamburger>) : RecyclerView.Adapter<HamburgerAdapter.HamburgerViewHolder>(){

    // Adapter pattern is a structural design pattern that allows objects with incompatible interfaces
    // to collaborate.It acts as a bridge between two classes that cannot work together due to incompatible
    // interfaces without modifying their source code.

    inner class HamburgerViewHolder(view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HamburgerAdapter.HamburgerViewHolder {
    }

    override fun onBindViewHolder(holder: HamburgerAdapter.HamburgerViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return hamburgers.size
    }


}