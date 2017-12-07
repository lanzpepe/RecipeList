package com.elano.recipelist.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.elano.recipelist.R
import com.elano.recipelist.view.RecipeListAdapter.Companion.RECIPE_DATA
import com.elano.recipelist.model.RecipeInfo
import kotlinx.android.synthetic.main.activity_full_recipe.*

class FullRecipeActivity : AppCompatActivity() {

    private lateinit var mIvRecipe: ImageView
    private lateinit var mTvIngredients: TextView
    private lateinit var mTvProcedures: TextView
    private lateinit var recipeInfo: RecipeInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_recipe)

        setViews()
        setRecipeDetails()
    }

    private fun setViews() {
        mIvRecipe = ivRecipe
        mTvIngredients = tvIngredients
        mTvProcedures = tvProcedures
    }

    private fun setRecipeDetails() {
        recipeInfo = intent.getParcelableExtra(RECIPE_DATA) as RecipeInfo
        title = recipeInfo.name
        mIvRecipe.setImageResource(recipeInfo.image)
        mTvIngredients.text = recipeInfo.ingredients
        mTvProcedures.text = recipeInfo.procedures
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState!!)
        outState.putInt("key-image", recipeInfo.image)
        outState.putString("key-ingredients", recipeInfo.ingredients)
        outState.putString("key-procedures", recipeInfo.procedures)
    }
}
