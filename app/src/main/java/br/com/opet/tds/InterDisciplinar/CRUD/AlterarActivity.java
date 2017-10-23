package br.com.opet.tds.InterDisciplinar.CRUD;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.opet.tds.InterDisciplinar.Bancos.BancoController;
import br.com.opet.tds.InterDisciplinar.Bancos.CriaBanco;
import br.com.opet.tds.InterDisciplinar.Model.Problema;
import br.com.opet.tds.InterDisciplinar.R;

public class AlterarActivity extends Activity {

    EditText problema;
    EditText sala;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        problema = (EditText)findViewById(R.id.editText3);
        sala = (EditText)findViewById(R.id.editText4);


        alterar = (Button)findViewById(R.id.button4);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        problema.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PROBLEMA)));
        sala.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SALA)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Problema problemaObj = new Problema();
                problemaObj.set_ID(Integer.parseInt(codigo));
                problemaObj.setProblema(problema.getText().toString());
                problemaObj.setSala(Integer.parseInt(sala.getText().toString()));
                crud.alteraRegistro(problemaObj);
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button5);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}