package br.com.opet.tds.InterDisciplinar.Model;

/**
 * Created by rhayf on 24/05/2017.
 */



public class Problema {
    private int _ID;
    private String problema;
    private int sala;
    private String bloco;
    private String data1;
    private String data2;
    private String setor;
    private String usuario;

    public Problema() {

    }

    public Problema(String problemaString, int salaInt, String blocoString, String data1String, String data2String, String setorString, String usuarioString) {

        this.problema = problema;
        this.sala = sala;
        this.bloco = bloco;
        this.data1 = data1;
        this.data2 = data2;
        this.setor = setor;
        this.usuario = usuario;
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

    public String getBloco() { return bloco; }

    public void setBloco(String bloco) { this.bloco = bloco; }

    public String getData1() { return data1; }

    public void setData1(String data1) { this.data1 = data1; }

    public String getData2() { return data2; }

    public void setData2(String data2) { this.data2 = data2; }

    public String getSetor() { return setor; }

    public void setSetor(String setor) { this.setor = setor; }

    public String getUsuario() { return usuario; }

    public void setUsuario(String usuario) { this.usuario = usuario; }
}
