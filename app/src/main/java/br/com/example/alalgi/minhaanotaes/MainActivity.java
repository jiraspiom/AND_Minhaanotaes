package br.com.example.alalgi.minhaanotaes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);

        //passo o contexto para a anotacoes preferencia
        preferencias = new AnotacaoPreferencias(getApplicationContext());



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textoRecuperado = editAnotacao.getText().toString();

                if (textoRecuperado.equals("")){
                    Snackbar.make(view, "Preenchar o texto", Snackbar.LENGTH_SHORT);

                }else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotacao salva com sucesso", Snackbar.LENGTH_SHORT);

                }


            }
        });

        //recuperando anotacao
        String recebeAnotacao = preferencias.recuperarAnotacao();
        //se anotao nao estiver vazia
        if(!recebeAnotacao.equals("")){
            editAnotacao.setText(recebeAnotacao);
        }
    }

}
