package br.edu.uniritter.mobile.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaPrincipal extends AppCompatActivity {
    static int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Button bt = findViewById(R.id.button);


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