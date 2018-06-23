package br.edu.ucsal.biblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.HashSet;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    Livro[] livros;
    HashSet<String> cursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) this.findViewById(R.id.listCursos);


        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get("https://raw.githubusercontent.com/letthaa/biblioteca/master/livros.json",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        livros = new Gson().fromJson(responseString, Livro[].class);

                        cursos = getCursos(livros);

                        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                cursos.toArray(new String[0])
                        );
                        listView.setAdapter(adapter);
                    }
                }
        );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                {
                    String curso = cursos.toArray(new String[0])[i];
                    Intent livrosActivity = new Intent(MainActivity.this, LivrosActivity.class);
                    ArrayList<Livro> livrosList = new ArrayList<>();
                    for (Livro livro : livros)
                        if (livro.getCurso().equals(curso))
                            livrosList.add(livro);
                    livrosActivity.putExtra("livros", livrosList.toArray(new Livro[0]));
                    startActivity(livrosActivity);
                }
            }
        });

    }

    private HashSet<String> getCursos(Livro[] livros) {
        HashSet<String> cursos = new HashSet<>();
        for (Livro livro : livros) {
            cursos.add(livro.getCurso());
        }
        return cursos;
    }


}
