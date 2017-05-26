package br.com.uniara.buscacep.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.activeandroid.Model;

import java.util.List;

import br.com.uniara.buscacep.R;
import br.com.uniara.buscacep.adapter.LocalAdapter;
import br.com.uniara.buscacep.database.dao.LocalDAO;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLocais;

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
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private List<Model> getLocais() {
        return LocalDAO.getInstance().getModelList();
    }

}