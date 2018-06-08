package br.edu.ucsal.biblioteca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        TextView titulo = (TextView) findViewById(R.id.titulo);
        TextView autor = (TextView) findViewById(R.id.autor);
        TextView edicao = (TextView) findViewById(R.id.edicao);
        TextView anoLancamento = (TextView) findViewById(R.id.anoLancamento);
        TextView descricao = (TextView) findViewById(R.id.descricao);

        Livro livro = (Livro) getIntent().getSerializableExtra("Livro");

        titulo.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        edicao.setText(livro.getEdicao().toString());
        anoLancamento.setText(livro.getAnoLancamento().toString());
        descricao.setText(livro.getDescricao());


    }
}
