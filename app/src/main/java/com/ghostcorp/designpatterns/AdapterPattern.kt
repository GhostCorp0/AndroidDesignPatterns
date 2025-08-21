package com.ghostcorp.designpatterns

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HamburgerAdapter(private val hamburgers : List<Hamburger>) : RecyclerView.Adapter<HamburgerAdapter.HamburgerViewHolder>(){

    inner class HamburgerViewHolder(view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HamburgerAdapter.HamburgerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HamburgerAdapter.HamburgerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}