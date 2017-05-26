package br.com.uniara.buscacep.database.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by andreguedes on 24/05/17.
 */
@Table(name = Local.TABLE_NAME)
public class Local extends Model {

    public static final String TABLE_NAME = "Local";
    public static final String CIDADE = "cidade";
    public static final String LOGRADOURO = "logradouro";
    public static final String BAIRRO = "bairro";
    public static final String ESTADO = "estado";
    public static final String CEP = "cep";

    @Column(name = CIDADE)
    private String cidade;

    @Column(name = LOGRADOURO)
    private String logradouro;

    @Column(name = BAIRRO)
    private String bairro;

    @Column(name = ESTADO)
    private String estado;

    @Column(name = CEP)
    private String cep;

    public Local() {
        super();
    }

    public Local(String cidade, String cep) {
        this(cidade, null, null, null, cep);
    }

    private Local(String cidade, String logradouro, String bairro, String estado, String cep) {
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

}