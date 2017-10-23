package br.com.opet.tds.InterDisciplinar.FirebaseLogin;

import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rhayf on 23/10/2017.
 */

public class Usuarios {
    private String Id;
    private String Email;
    private String Senha;
    private String Nome;

    public Usuarios() {
    }

    public void salvar(){
        DatabaseReference referenciaFirebase = ConfigFireBase.getFirebase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> hashMapUsuario = new HashMap<>();
        hashMapUsuario.put("id",getId());
        hashMapUsuario.put("email",getEmail());
        hashMapUsuario.put("senha",getSenha());

        return hashMapUsuario;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
