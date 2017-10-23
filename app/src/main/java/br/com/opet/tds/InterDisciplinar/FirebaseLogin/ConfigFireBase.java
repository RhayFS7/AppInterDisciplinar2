package br.com.opet.tds.InterDisciplinar.FirebaseLogin;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by rhayf on 23/10/2017.
 */

public class ConfigFireBase {

    private static DatabaseReference refenciaFirebase;
    private static FirebaseAuth autenticaçao;

    public static DatabaseReference getFirebase(){
        if (refenciaFirebase == null){
            refenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return refenciaFirebase;
    }

    public static FirebaseAuth getFirebaseAutenticaçao(){
        if (autenticaçao == null){
            autenticaçao = FirebaseAuth.getInstance();
        }
        return autenticaçao;
    }
}
