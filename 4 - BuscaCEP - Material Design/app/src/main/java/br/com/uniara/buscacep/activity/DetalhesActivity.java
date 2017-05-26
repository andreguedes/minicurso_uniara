package br.com.uniara.buscacep.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;

import java.io.IOException;

import br.com.uniara.buscacep.R;
import br.com.uniara.buscacep.database.model.Local;
import br.com.uniara.buscacep.database.pojo.LocalPOJO;
import br.com.uniara.buscacep.service.BuscaCEPService;

public class DetalhesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtBusca;
    ImageButton btnBusca;
    Button btnAdicionar;

    TextView txtCidade, txtCep;

    View progressBar;

    Local local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        edtBusca = (EditText) findViewById(R.id.edtBusca);
        btnBusca = (ImageButton) findViewById(R.id.btnBusca);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        txtCidade = (TextView) findViewById(R.id.txtCidade);
        txtCep = (TextView) findViewById(R.id.txtCep);

        progressBar = findViewById(R.id.progressBar);

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
                String busca = edtBusca.getText().toString();
                if (busca.equals("")) {
                    showToast("Preencha o campo de busca");
                } else {
                    BuscaCEPTask task = new BuscaCEPTask();
                    task.execute(edtBusca.getText().toString());

                    esconderTeclado(edtBusca);
                }
                break;
            case R.id.btnAdicionar:
                fillCeps(local);
                break;
        }
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void fillCeps(Local local) {
        if (local != null) {
            ActiveAndroid.beginTransaction();

            try {
                local.save();

                ActiveAndroid.setTransactionSuccessful();
                showToast("Local salvo com sucesso");
            } catch (Exception e) {
                Toast.makeText(this, "Erro ao salvar as informações!", Toast.LENGTH_SHORT).show();
            } finally {
                ActiveAndroid.endTransaction();

                finish();
            }
        }
    }

    private void preencherCampos(LocalPOJO localPOJO) {
        if (localPOJO != null) {
            txtCidade.setText(localPOJO.getCidade());
            txtCep.setText(localPOJO.getCep());

            local = new Local(localPOJO.getCidade(), localPOJO.getCep());
        } else {
            showToast("CEP não encontrado!");
        }
    }

    private class BuscaCEPTask extends AsyncTask<String, Void, LocalPOJO> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected LocalPOJO doInBackground(String... params) {
            LocalPOJO local = null;

            try {
                Thread.sleep(3000);
                local = BuscaCEPService.run(params[0]);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return local;
        }

        @Override
        protected void onPostExecute(LocalPOJO local) {
            super.onPostExecute(local);

            preencherCampos(local);
            progressBar.setVisibility(View.GONE);
        }

    }

    private void esconderTeclado(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}