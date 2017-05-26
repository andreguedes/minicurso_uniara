package br.com.uniara.buscacep.service;

import com.google.gson.Gson;

import java.io.IOException;

import br.com.uniara.buscacep.database.pojo.LocalPOJO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by andreguedes on 26/05/17.
 */

public class BuscaCEPService {

    private static String URL = "http://api.postmon.com.br/v1/cep/";

    private static OkHttpClient client = new OkHttpClient();

    public static LocalPOJO run(String cep) throws IOException {
        Request request = new Request.Builder()
                .url(URL.concat(cep))
                .build();

        Response response = client.newCall(request).execute();
        LocalPOJO localPOJO = null;
        if (response.isSuccessful())
             localPOJO = new Gson().fromJson(response.body().string(), LocalPOJO.class);
        return localPOJO;
    }

}