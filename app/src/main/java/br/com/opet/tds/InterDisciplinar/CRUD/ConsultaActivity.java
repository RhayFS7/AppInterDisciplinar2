package br.com.opet.tds.InterDisciplinar.CRUD;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.opet.tds.InterDisciplinar.Bancos.BancoController;
import br.com.opet.tds.InterDisciplinar.Bancos.CriaBanco;
import br.com.opet.tds.InterDisciplinar.R;

/**
 * Created by rhayf on 24/05/2017.
 */

public class ConsultaActivity extends Activity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {CriaBanco.ID, CriaBanco.PROBLEMA, CriaBanco.SALA, CriaBanco.BLOCO, CriaBanco.DATA1, CriaBanco.DATA2, CriaBanco.SETOR, CriaBanco.USUARIO};
        int[] idViews = new int[] {R.id.idProblema, R.id.nomeProblema, R.id.numeroSala, R.id.nomeBloco, R.id.nomeData1, R.id.nomeData2, R.id.nomeSetor, R.id.nomeUsuario};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_problemas,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                Intent intent = new Intent(ConsultaActivity.this, AlterarActivity.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
