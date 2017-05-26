package br.com.uniara.buscacep;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import br.com.uniara.buscacep.database.model.Local;

/**
 * Created by andreguedes on 26/05/17.
 */

public class BuscaCEPApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        configureModels(this);
        ActiveAndroid.initialize(this);
    }

    private void configureModels(final Context context) {
        Configuration.Builder configurationBuilder = new Configuration.Builder(context);
        configurationBuilder.addModelClasses(Local.class);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        ActiveAndroid.dispose();
    }

}