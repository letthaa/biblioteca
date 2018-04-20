package br.edu.ucsal.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        TextView titulo = findViewById(R.id.titulo);
        TextView autor = findViewById(R.id.autor);
        TextView edicao = findViewById(R.id.edicao);
        TextView anoLancamento = findViewById(R.id.anoLancamento);
        TextView descricao = findViewById(R.id.descricao);

        Livro livro = (Livro) getIntent().getSerializableExtra("Livro");

        titulo.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        edicao.setText(livro.getEdicao().toString());
        anoLancamento.setText(livro.getAnoLancamento().toString());
        descricao.setText(livro.getDescricao());


    }
}
