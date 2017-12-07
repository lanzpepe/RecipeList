package com.elano.recipelist.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.elano.recipelist.R
import com.elano.recipelist.model.RecipeInfo
import com.elano.recipelist.view.ItemDividerDecoration
import com.elano.recipelist.view.RecipeListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRecipes: ArrayList<RecipeInfo>
    private lateinit var mAdapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewInit()
        prepareRecipeData()
    }

    private fun recyclerViewInit() {
        val recyclerView = recycler_view

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(ItemDividerDecoration(this, LinearLayoutManager.VERTICAL))
        mRecipes = ArrayList()
        mAdapter = RecipeListAdapter(this, mRecipes)
        recyclerView.adapter = mAdapter
    }

    private fun prepareRecipeData() {
        mRecipes.add(RecipeInfo(getString(R.string.text_sandwich),
                getString(R.string.text_sandwich_desc), R.drawable.kale_lemon_sandwich,
                getString(R.string.text_sandwich_ingredients),
                getString(R.string.text_sandwich_procedures)))
        mRecipes.add(RecipeInfo(getString(R.string.text_salad),
                getString(R.string.text_salad_desc), R.drawable.mango_lime_bean_salad))
        mRecipes.add(RecipeInfo(getString(R.string.text_soup),
                getString(R.string.text_soup_desc), R.drawable.sweet_potato_and_lentil_soup))
        mRecipes.add(RecipeInfo(getString(R.string.text_mousse),
                getString(R.string.text_mousse_desc), R.drawable.lime_mousse))
        mRecipes.add(RecipeInfo(getString(R.string.text_soup),
                getString(R.string.text_soup_desc), R.drawable.sweet_potato_and_lentil_soup))
        mRecipes.add(RecipeInfo(getString(R.string.text_salad),
                getString(R.string.text_salad_desc), R.drawable.mango_lime_bean_salad))

        mAdapter.notifyDataSetChanged()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState!!)
        outState.putParcelableArrayList("key-recipe", mRecipes)
    }
}