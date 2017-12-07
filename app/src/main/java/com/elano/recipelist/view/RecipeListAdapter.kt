package com.elano.recipelist.view

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.elano.recipelist.R
import com.elano.recipelist.controller.FullRecipeActivity
import com.elano.recipelist.model.RecipeInfo
import kotlinx.android.synthetic.main.recipe_list_row.view.*

/**
 * Created by Jess on 12/5/2017.
 */
class RecipeListAdapter(context: Context, private val recipe: List<RecipeInfo>) : RecyclerView.Adapter<RecipeListAdapter.MyViewHolder>() {

    private var mContext = context

    companion object {
        val RECIPE_DATA = "key-data"
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder =
            MyViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recipe_list_row, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder!!.tvNameHolder.text = recipe[position].name
        holder.tvDescriptionHolder.text = recipe[position].description
        holder.onClicked(object : ClickListener {
            override fun onClicked(view: View, position: Int) {
                if (holder.adapterPosition == position) {
                    val intent = Intent(mContext, FullRecipeActivity::class.java)
                    intent.putExtra(RECIPE_DATA, recipe[position])
                    mContext.startActivity(intent)
                }
            }
        })
    }

    override fun getItemCount(): Int = recipe.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var clickListener: ClickListener
        val tvNameHolder: TextView = itemView.tvNameHolder
        val tvDescriptionHolder: TextView = itemView.tvDescriptionHolder

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.clickListener.onClicked(v!!, adapterPosition)
        }

        fun onClicked(clickListener: ClickListener) {
            this.clickListener = clickListener
        }
    }

    interface ClickListener {
        fun onClicked(view: View, position: Int)
    }
}