package br.edu.uniritter.mobile.meuprimeiroapp.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.uniritter.mobile.meuprimeiroapp.DetalheTodoActivity;
import br.edu.uniritter.mobile.meuprimeiroapp.R;
import br.edu.uniritter.mobile.meuprimeiroapp.model.Todo;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private List<Todo> todos;

    public TodoAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflar e criar o layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_detalhe2, parent, false);

        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        TextView tv = holder.viewTodo.findViewById(R.id.textviewtitulo);
        tv.setText(todos.get(position).getTitle());
        CheckBox cb = holder.viewTodo.findViewById(R.id.cbCompleted);
        cb.setChecked(todos.get(position).isCompleted());
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetalheTodoActivity.class);
                intent.putExtra("objTodo", todos.get(position));
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewTodo;
        public TodoViewHolder(View view) {
            super(view);
            this.viewTodo = view;

        }
    }
}
