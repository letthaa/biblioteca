package br.edu.ucsal.biblioteca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) this.findViewById(R.id.listCursos);

        final ArrayList<String> cursos = new ArrayList<>();

        cursos.add("Engenharia de Software ");
        cursos.add("Nutrição");
        cursos.add("Biologia");
        cursos.add("Direito");
        cursos.add("Enfermagem");
        cursos.add("Engenharia Civil");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cursos
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                {
                    Intent livrosActivity = new Intent(MainActivity.this, LivrosActivity.class);
                    livrosActivity.putExtra("textCursos", cursos.get(i));
                    startActivity(livrosActivity);
                }
            }
        });

    }


}
