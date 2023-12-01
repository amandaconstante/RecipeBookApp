package com.restauranteaplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.restauranteaplication.adapter.RecipeAdapter;
import com.restauranteaplication.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Recipe> recipeList = new ArrayList<>();
    private RecipeAdapter recipeAdapter;
    private GetRecipeData getRecipeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerViewRecipe = findViewById(R.id.rv_recipeList);
        recyclerViewRecipe.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewRecipe.setHasFixedSize(true);

        recipeAdapter = new RecipeAdapter(recipeList, this);
        recyclerViewRecipe.setAdapter(recipeAdapter);

        getRecipeData = new GetRecipeData(this);

        EditText etSearchQuery = findViewById(R.id.et_searchInput);

        // Botão para pesquisar receitas (substitua com o ID do seu botão)
        findViewById(R.id.btn_searchMeal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtenha o texto digitado pelo usuário
                String searchQuery = etSearchQuery.getText().toString();

                // Chame o método para obter receitas quando o botão for clicado
                getRecipes(searchQuery);
            }
        });
    }

    private void getRecipes(String searchQuery) {
        // Limpa a lista atual antes de adicionar novas receitas
        recipeList.clear();
        getRecipeData.getRecipeData(searchQuery);
    }

    public void updateRecipeList(List<Recipe> recipes) {
        // Atualiza a lista de receitas e notifica o adapter
        recipeList.addAll(recipes);
        recipeAdapter.notifyDataSetChanged();
    }

    // Adicione outros métodos conforme necessário, como onDeleteRecipeClick para lidar com a exclusão
}
