package br.com.uniara.buscacep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class DetalhesActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VALUE_PASS_BY_INTENT = "value";

    EditText edtBusca;
    ImageButton btnBusca;
    Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        String value = getIntent().getStringExtra(VALUE_PASS_BY_INTENT);
        if (value != null)
            showToast(value);

        edtBusca = (EditText) findViewById(R.id.edtBusca);
        btnBusca = (ImageButton) findViewById(R.id.btnBusca);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        btnBusca.setOnClickListener(this);
        btnAdicionar.setOnClickListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBusca:
                showToast("Clicou no botão de busca");
                break;
            case R.id.btnAdicionar:
                showToast("Clicou no botão de adicionar");
                break;
        }
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}