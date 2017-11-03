package br.com.opet.tds.InterDisciplinar.Bancos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rhayf on 24/05/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "problemas";
    public static final String ID = "_id";
    public static final String PROBLEMA = "problema";
    public static final String SALA = "sala";
    public static final String BLOCO = "bloco";
    public static final String DATA1 = "data1";
    public static final String DATA2 = "data2";
    public static final String SETOR = "setor";
    public static final String USUARIO = "usuario";
    public static final int VERSAO = 2;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + PROBLEMA + " varchar2(100),"
                + SALA + " integer,"
                + BLOCO + " varchar2(100),"
                + DATA1 + " varchar2(100),"
                + DATA2 + " varchar2(100),"
                + SETOR + " varchar2(100),"
                + USUARIO + " varchar2(100) "
                +");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
