package br.edu.ucsal.biblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LivroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro);

        ListView listView = (ListView)this.findViewById(R.id.listLivros);

        final ArrayList<String> cursos = new ArrayList<>();
        cursos.add("Engenharia de Software");
    }
}
