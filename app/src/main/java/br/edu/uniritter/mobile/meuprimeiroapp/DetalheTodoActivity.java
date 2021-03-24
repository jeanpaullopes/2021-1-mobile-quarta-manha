package br.edu.uniritter.mobile.meuprimeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import br.edu.uniritter.mobile.meuprimeiroapp.model.Pessoa;
import br.edu.uniritter.mobile.meuprimeiroapp.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        //Todo todo = intent.getParcelableExtra("objTodo");
        Parcelable prc = intent.getParcelableExtra("objTodo");
                setContentView(R.layout.activity_detalhe_todo);

            populaTela((Todo) prc);



    }

    private void populaTela(Todo obj) {
        TextView tv = findViewById(R.id.tvId);
        tv.setText(obj.getId()+"");
        tv = findViewById(R.id.tvIdUser);
        tv.setText(obj.getUserId()+"");
        tv = findViewById(R.id.textviewtitulo);
        tv.setText(obj.getTitle());
        CheckBox cb = findViewById(R.id.cbCompleted);
        cb.setChecked(obj.isCompleted());

    }
    private void populaTela(Pessoa obj) {
        TextView tv = findViewById(R.id.tvId);
        tv = findViewById(R.id.textviewtitulo);
        tv.setText(obj.nome);


    }
    public void trocaLayout(View v){
        setContentView(R.layout.layout_detalhe2);
        Todo todo = getIntent().getParcelableExtra("objTodo");
        populaTela(todo);

    }
}