package com.voteme.duodroid.voteme.model;

/**
 * Created by mhamd on 27/11/2016.
 */
public class Poste {
    private String name;
    private int code_pst;
    private String adresse;
    private String region;
    private Double lg;
    private Double lt;

    public Poste() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLt() {
        return lt;
    }

    public void setLt(Double ln) {
        this.lt = ln;
    }

    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCode_pst() {
        return code_pst;
    }

    public void setCode_pst(int code_pst) {
        this.code_pst = code_pst;
    }
}
