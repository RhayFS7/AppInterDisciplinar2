package br.com.opet.tds.InterDisciplinar.Bancos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.opet.tds.InterDisciplinar.Model.Problema;

/**
 * Created by Gustavo on 24/05/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(Problema problema){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.PROBLEMA, problema.getProblema());
        valores.put(CriaBanco.SALA, problema.getSala());
        valores.put(CriaBanco.BLOCO, problema.getBloco());
        valores.put(CriaBanco.DATA1, problema.getData1());
        valores.put(CriaBanco.DATA2, problema.getData2());
        valores.put(CriaBanco.SETOR, problema.getSetor());
        valores.put(CriaBanco.USUARIO, problema.getUsuario());


        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir Manutenção";
        else
            return "Manutenção inserida com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.PROBLEMA, banco.SALA, banco.BLOCO, banco.DATA1, banco.DATA2, banco.SETOR, banco.USUARIO};
        db = banco.getReadableDatabase();

        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.PROBLEMA,banco.SALA, banco.BLOCO, banco.DATA1, banco.DATA2, banco.SETOR, banco.USUARIO};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(Problema problema){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + problema.get_ID();

        valores = new ContentValues();
        valores.put(CriaBanco.PROBLEMA, problema.getProblema());
        valores.put(CriaBanco.SALA, problema.getSala());
        valores.put(CriaBanco.BLOCO, problema.getBloco());
        valores.put(CriaBanco.DATA1, problema.getData1());
        valores.put(CriaBanco.DATA2, problema.getData2());
        valores.put(CriaBanco.SETOR, problema.getSetor());
        valores.put(CriaBanco.USUARIO, problema.getUsuario());

        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();

        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }
}
