package br.com.opet.tds.InterDisciplinar.CRUD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.opet.tds.InterDisciplinar.Bancos.BancoController;
import br.com.opet.tds.InterDisciplinar.Model.Problema;
import br.com.opet.tds.InterDisciplinar.R;

/**
 * Created by Gustavo on 24/05/2017.
 */

public class CadastrarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText problema  = (EditText)findViewById(R.id.editText);
                EditText sala = (EditText)findViewById((R.id.editText2));
                String problemaString = problema.getText().toString();
                int salaInt = Integer.parseInt(sala.getText().toString());
                String resultado;

                Problema problemas = new Problema(problemaString,salaInt);
                    resultado = crud.insereDado(problemas);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastrarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
