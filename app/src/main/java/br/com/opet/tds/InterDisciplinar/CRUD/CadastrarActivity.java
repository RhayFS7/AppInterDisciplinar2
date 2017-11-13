package br.com.opet.tds.InterDisciplinar.CRUD;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                EditText bloco = (EditText) findViewById ((R.id.editText3));
                EditText data1 = (EditText) findViewById ((R.id.editText4));
                EditText data2 = (EditText) findViewById ((R.id.editText5));
                EditText setor = (EditText) findViewById ((R.id.editText6));
                EditText usuario = (EditText) findViewById ((R.id.editText7));

                String problemaString = problema.getText().toString();
                int salaInt = Integer.parseInt(sala.getText().toString());
                String blocoString = bloco.getText().toString();
                String data1String = data1.getText().toString();
                String data2String = data2.getText().toString();
                String setorString = setor.getText().toString();
                String usuarioString = usuario.getText().toString();
                String resultado;

                Log.i("INSERT",blocoString);

                Problema problemas = new Problema(problemaString,salaInt,blocoString,data1String,data2String,setorString,usuarioString);
                    resultado = crud.insereDado(problemas);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CadastrarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();


            }
        });


    }
}
