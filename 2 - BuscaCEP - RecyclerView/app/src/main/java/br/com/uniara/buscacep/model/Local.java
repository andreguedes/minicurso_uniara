package br.com.uniara.buscacep.model;

/**
 * Created by andreguedes on 24/05/17.
 */

public class Local {

    private String cidade;
    private String logradouro;
    private String bairro;
    private String estado;
    private String cep;

    public Local(String cidade, String cep) {
        this(cidade, null, null, null, cep);
    }

    public Local(String cidade, String logradouro, String bairro, String estado, String cep) {
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