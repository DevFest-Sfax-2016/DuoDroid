package com.voteme.duodroid.voteme.model;

/**
 * Created by mhamd on 27/11/2016.
 */
public class Poste {
    private String name;
    private int code_pst;
    private String adresse;
    private String region;
    private String lg;
    private String lt;

    public Poste() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String ln) {
        this.lt = ln;
    }

    public String getLg() {
        return lg;
    }

    public void setLg(String lg) {
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
