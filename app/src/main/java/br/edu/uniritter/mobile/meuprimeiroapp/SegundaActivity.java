package br.edu.uniritter.mobile.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Button bt = findViewById(R.id.button2);
        Intent intent = getIntent();
        String nomeQueVeio = intent.getStringExtra("nome");
        int rod = intent.getIntExtra("rodada",-1);
        bt.setText(nomeQueVeio+" "+rod+"x ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String nomeQueVeio = intent.getStringExtra("nome");
        Toast toast = Toast.makeText(this.getApplicationContext(), "olá "+nomeQueVeio, Toast.LENGTH_LONG);
        toast.show();


    }

    public void clique(View view){

    }
}