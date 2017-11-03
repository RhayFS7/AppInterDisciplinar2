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
    EditText bloco;
    EditText data1;
    EditText data2;
    EditText setor;
    EditText usuario;
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

        problema = (EditText)findViewById(R.id.editText8);
        sala = (EditText)findViewById(R.id.editText9);
        bloco = (EditText)findViewById(R.id.editText10);
        data1 = (EditText)findViewById(R.id.editText11);
        data2 = (EditText)findViewById(R.id.editText12);
        setor = (EditText)findViewById(R.id.editText13);
        usuario = (EditText)findViewById(R.id.editText14);


        alterar = (Button)findViewById(R.id.button4);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        problema.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PROBLEMA)));
        sala.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SALA)));
        bloco.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.BLOCO)));
        data1.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DATA1)));
        data2.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DATA2)));
        setor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.SETOR)));
        usuario.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.USUARIO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Problema problemaObj = new Problema();
                problemaObj.set_ID(Integer.parseInt(codigo));
                problemaObj.setProblema(problema.getText().toString());
                problemaObj.setSala(Integer.parseInt(sala.getText().toString()));
                problemaObj.setBloco(bloco.getText().toString());
                problemaObj.setData1(data1.getText().toString());
                problemaObj.setData2(data2.getText().toString());
                problemaObj.setSetor(setor.getText().toString());
                problemaObj.setUsuario(usuario.getText().toString());
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