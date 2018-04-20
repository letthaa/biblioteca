package br.edu.ucsal.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class LivrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);

        ListView listView = (ListView) this.findViewById(R.id.listLivros);

        final ArrayList<Livro> livros = new ArrayList<>();

        Livro livro = new Livro("Redes de Computadores", "Marco Câmara", 1, 1, "Melhor livro");

        livros.add(livro);
//        livros.add("Sistemas Operacionais Modernos");
//        livros.add("Sistemas Operacionais: Projeto e Implementação");
//        livros.add("Organização Estruturada de Computadores");
//        livros.add("Sistemas Distribuídos: Princípios e Paradigmas");
//        livros.add("Engenharia de Software");

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
                    detalheActivity.putExtra("Livro", (Serializable) livros.get(i));
                    startActivity(detalheActivity);
                }
            }
        });

    }
}
