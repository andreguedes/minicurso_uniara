package br.com.uniara.buscacep;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.uniara.buscacep.adapter.LocalAdapter;
import br.com.uniara.buscacep.model.Local;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLocais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        rvLocais = (RecyclerView) findViewById(R.id.rv_locais);
        rvLocais.setHasFixedSize(true);
        rvLocais.setLayoutManager(new LinearLayoutManager(this));
        rvLocais.setItemAnimator(new DefaultItemAnimator());

        final LocalAdapter adapter = new LocalAdapter(this, getLocais());
        rvLocais.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_adicionar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_adicionar) {
            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra(DetalhesActivity.VALUE_PASS_BY_INTENT, "Valor passado para a próxima tela");
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    // Mock de dados para popular o RecyclerView
    private List<Local> getLocais() {
        List<Local> locais = new ArrayList<>();
        locais.add(new Local("Araraquara", "14800000"));
        locais.add(new Local("Matão", "14990000"));
        locais.add(new Local("São Carlos", "13570000"));
        locais.add(new Local("Ribeirão Preto", "14070000"));
        locais.add(new Local("Jaboticabal", "14870000"));
        locais.add(new Local("Campinas", "13050000"));
        locais.add(new Local("São Paulo", "01018000"));
        return locais;
    }

}