package com.restauranteaplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.restauranteaplication.R;
import com.restauranteaplication.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private Context context;

    public RecipeAdapter(List<Recipe> recipeList, Context context) {
        this.recipeList = recipeList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);

        holder.tvRecipeName.setText(recipe.getRecipeName());
        holder.tvRecipeCategory.setText(recipe.getRecipeCategory());
        holder.tvRecipeInstructions.setText(recipe.getRecipeInstructions());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView tvRecipeName, tvRecipeCategory, tvRecipeInstructions;
        Button btnDeleteRecipe;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRecipeName = itemView.findViewById(R.id.tv_recipeName);
            tvRecipeCategory = itemView.findViewById(R.id.tv_recipeCategory);
            tvRecipeInstructions = itemView.findViewById(R.id.tv_recipeInstructions);

        }
    }
}