package br.edu.uniritter.mobile.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TelaPrincipal extends AppCompatActivity {
    static int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Button bt = findViewById(R.id.button);

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://jsonplaceholder.typicode.com/todos";

        // Request de JsonArray da URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject jsonObject = response.getJSONObject(0);
                            Toast.makeText(getApplicationContext(),jsonObject.toString(),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            Log.e("erro",e.getMessage());
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });



        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);




    }

    public void cliqueBt(View view){
        Intent intent = new Intent(this, SegundaActivity.class);

        EditText edT = findViewById(R.id.editText);
        String nome = edT.getText().toString();
        cont++;
        intent.putExtra("rodada", cont);
        intent.putExtra("nome", nome);

        startActivity(intent);

    }


}