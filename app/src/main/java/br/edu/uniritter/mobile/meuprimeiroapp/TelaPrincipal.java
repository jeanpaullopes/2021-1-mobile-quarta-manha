package br.edu.uniritter.mobile.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import java.util.ArrayList;

import br.edu.uniritter.mobile.meuprimeiroapp.model.Todo;

public class TelaPrincipal extends AppCompatActivity implements Response.Listener<JSONArray>,
                                                                Response.ErrorListener{

    ArrayList<Todo> todos = new ArrayList<Todo>();
    static int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Button bt = findViewById(R.id.button);
        //para o futuro
        //if (todos.size() == 0) {
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);
            String url = "https://jsonplaceholder.typicode.com/todos";

            // Request de JsonArray da URL.

            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                    this, this);


            // Add the request to the RequestQueue.
            queue.add(jsonArrayRequest);

        //}


    }

    public void cliqueBt(View view){
        Intent intent = new Intent(this, SegundaActivity.class);

        EditText edT = findViewById(R.id.editText);
        String nome = edT.getText().toString();
        cont++;
        intent.putExtra("rodada", cont);
        intent.putExtra("nome", nome);
        /*
        intent.putExtra("idUser",todos.get(4).getUserId());
        intent.putExtra("id",todos.get(4).getId());
        intent.putExtra("title",todos.get(4).getTitle());
        intent.putExtra("completed",todos.get(4).isCompleted());
         */
        intent.putExtra("todo",todos.get(4));

        startActivity(intent);

    }


    @Override
    public void onResponse(JSONArray response) {
        try {


            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Todo obj = new Todo(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed"));
                todos.add(obj);

            }
            for(Todo obj1 : todos) {
                TextView tv = findViewById(R.id.tv_todos);
                tv.setText(tv.getText().toString()+"\n"+obj1.getTitle());
            }
        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"deu erro: "+msg,Toast.LENGTH_LONG).show();
    }
}