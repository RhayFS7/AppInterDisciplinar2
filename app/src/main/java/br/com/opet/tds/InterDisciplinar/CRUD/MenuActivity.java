package br.com.opet.tds.InterDisciplinar.CRUD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.opet.tds.InterDisciplinar.API.HelperLinkActivity;
import br.com.opet.tds.InterDisciplinar.GoogleMaps.MapsActivity;
import br.com.opet.tds.InterDisciplinar.Others.ListClubeActivity;
import br.com.opet.tds.InterDisciplinar.R;

/**
 * Created by rhayf on 24/05/2017.
 */

public class MenuActivity extends Activity {

   // private FirebaseAuth usuarioFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       // usuarioFirebase = ConfigFireBase.getFirebaseAutenticaçao();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sair) {
            deslogarUsuario();
        }

        return super.onOptionsItemSelected(item);
    }
*/
    public void inserir(View v){
        Intent intent = new Intent(MenuActivity.this,CadastrarActivity.class);
        startActivity(intent);
    }

    public void listar(View v) {
        Intent intent = new Intent(MenuActivity.this, ListClubeActivity.class);
        startActivity(intent);
    }

    public void alterar(View v){
        Intent intent = new Intent(MenuActivity.this,AlterarActivity.class);
        startActivity(intent);
    }
    public void listar2(View v) {
        Intent intent = new Intent(MenuActivity.this, ConsultaActivity.class);
        startActivity(intent);
    }

    public void mapa(View v) {
        Intent intent = new Intent(MenuActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void helper(View v) {
        Intent intent = new Intent(MenuActivity.this, HelperLinkActivity.class);
        startActivity(intent);
    }


/*
    private void deslogar(View v) {
        usuarioFirebase.signOut();
        Intent intent = new Intent(MenuActivity.this, TelaPrincipalActivity.class);
        startActivity(intent);
        finish();
    }
*/

}
