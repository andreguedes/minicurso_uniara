package br.com.uniara.buscacep.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.activeandroid.Model;

import java.util.List;

import br.com.uniara.buscacep.R;
import br.com.uniara.buscacep.adapter.LocalAdapter;
import br.com.uniara.buscacep.database.dao.LocalDAO;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLocais;
    private FloatingActionButton fabAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        initInstances();
    }

    private void initInstances() {
        rvLocais = (RecyclerView) findViewById(R.id.rv_locais);
        rvLocais.setHasFixedSize(true);
        rvLocais.setLayoutManager(new LinearLayoutManager(this));
        rvLocais.setItemAnimator(new DefaultItemAnimator());

        final LocalAdapter adapter = new LocalAdapter(this, getLocais());
        rvLocais.setAdapter(adapter);

        fabAdicionar = (FloatingActionButton) findViewById(R.id.fabAdicionar);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fabAdicionar.show();
            }
        }, 500);
        fabAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Model> getLocais() {
        return LocalDAO.getInstance().getModelList();
    }

}