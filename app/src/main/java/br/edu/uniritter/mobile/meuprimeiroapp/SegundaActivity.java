package br.edu.uniritter.mobile.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.uniritter.mobile.meuprimeiroapp.model.Todo;

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
        TextView tv;
        Todo todo = intent.getParcelableExtra("todo");
        tv = findViewById(R.id.tv_idUser);
        //tv.setText(intent.getIntExtra("idUser",0)+"");
        tv.setText(todo.getUserId()+"");
        todo.setTitle("Novo Título");
        //troquei a referência
        tv = findViewById(R.id.tv_id);
        //tv.setText(intent.getIntExtra("id",0)+"");
        tv.setText(todo.getId()+"");

        tv = findViewById(R.id.tv_title);
        //tv.setText(intent.getStringExtra("title"));
        tv.setText(todo.getTitle());

        tv = findViewById(R.id.tv_completed);
        //tv.setText(intent.getBooleanExtra("completed",false)+"");
        tv.setText(todo.isCompleted()+"");

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