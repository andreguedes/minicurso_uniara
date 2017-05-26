package br.com.uniara.buscacep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSegunda = (Button) findViewById(R.id.btnSegunda);
        btnSegunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirProximaTela();
            }
        });

    }

    private void abrirProximaTela() {
        Intent intent = new Intent(this, DetalhesActivity.class);
        intent.putExtra(DetalhesActivity.KEY, "Valor passado para a próxima tela");
        startActivity(intent);
    }

}