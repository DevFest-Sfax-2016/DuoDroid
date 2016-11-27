package com.voteme.duodroid.voteme.model;

/**
 * Created by mhamd on 27/11/2016.
 */
public class Agent {
    private String name;
    private int code_pst;
    private int score;
    private String email;
    private String keyid;

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public Agent() {
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode_pst() {
        return code_pst;
    }

    public void setCode_pst(int code_pst) {
        this.code_pst = code_pst;
    }
}
