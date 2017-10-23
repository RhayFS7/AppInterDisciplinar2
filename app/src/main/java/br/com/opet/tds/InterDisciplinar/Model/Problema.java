package br.com.opet.tds.InterDisciplinar.Model;

/**
 * Created by rhayf on 24/05/2017.
 */



public class Problema {
    private int _ID;
    private String problema;
    private int sala;


    public Problema() {
    }

    public Problema(String problema, int sala) {
        this.problema = problema;
        this.sala = sala;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
}
