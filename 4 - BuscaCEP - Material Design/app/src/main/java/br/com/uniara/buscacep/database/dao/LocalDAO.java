package br.com.uniara.buscacep.database.dao;

import com.activeandroid.Model;
import com.activeandroid.query.Select;

import java.util.List;

import br.com.uniara.buscacep.database.model.Local;

/**
 * Created by andreguedes on 26/05/17.
 */

public class LocalDAO {

    private static LocalDAO INSTANCE;

    private LocalDAO() {}

    public static synchronized LocalDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalDAO();
        }
        return INSTANCE;
    }

    public List<Model> getModelList() {
        return new Select().all().from(Local.class).execute();
    }

}