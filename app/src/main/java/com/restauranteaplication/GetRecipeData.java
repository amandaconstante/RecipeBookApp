package com.restauranteaplication;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.restauranteaplication.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetRecipeData {
    private MainActivity mainActivity;
    private static final String MEAL_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    public GetRecipeData(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void getRecipeData(String mealName) {
        String mealUrl = MEAL_URL + mealName;

        // Cria uma fila de requisição
        RequestQueue queue = Volley.newRequestQueue(mainActivity);

        JsonObjectRequest mealRequest = new JsonObjectRequest(Request.Method.GET, mealUrl, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Verifique se a chave "meals" existe na resposta JSON
                            if (response.has("meals")) {
                                JSONArray mealsArray = response.getJSONArray("meals");

                                if (mealsArray.length() > 0) {
                                    List<Recipe> recipeList = new ArrayList<>();

                                    for (int i = 0; i < mealsArray.length(); i++) {
                                        JSONObject mealObject = mealsArray.getJSONObject(i);
                                        String foundMealName = mealObject.getString("strMeal");
                                        String mealCategory = mealObject.getString("strCategory");
                                        String mealInstructions = mealObject.getString("strInstructions");

                                        Recipe recipe = new Recipe(foundMealName, mealCategory, mealInstructions);
                                        recipeList.add(recipe);
                                    }

                                    // Atualiza a lista de receitas na MainActivity
                                    mainActivity.updateRecipeList(recipeList);
                                } else {
                                    // Handle the case when the "meals" array is empty
                                    Toast.makeText(mainActivity, "No meals found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                // Toast para aviso se formato invalido
                                Toast.makeText(mainActivity, "Error: Invalid response format", Toast.LENGTH_SHORT).show();
                                Log.e("API_ERROR", "Error: Invalid response format. Key 'meals' not found.");
                            }
                        } catch (JSONException e) {
                            // retornou valor nullo ou não JSON
                            e.printStackTrace();
                            Toast.makeText(mainActivity, "Recipe not found", Toast.LENGTH_SHORT).show();
                            Log.e("API_ERROR", "Error parsing JSON: " + e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mainActivity, "Network error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("API_ERROR", "Error response: " + error.toString());
                    }
                });

        // Adiciona a requisição à fila
        queue.add(mealRequest);
    }
}
