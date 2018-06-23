package br.edu.ucsal.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LivrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);

        ListView listView = (ListView) this.findViewById(R.id.listLivros);

        final Livro[] livros = (Livro[]) getIntent().getSerializableExtra("livros");

        final ArrayAdapter<Livro> adapter = new ArrayAdapter<Livro>(
                this,
                android.R.layout.simple_list_item_1,
                livros
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                {
                    Intent detalheActivity = new Intent(LivrosActivity.this, DetalheActivity.class);
                    detalheActivity.putExtra("Livro", livros[i]);
                    startActivity(detalheActivity);
                }
            }
        });

    }
}
