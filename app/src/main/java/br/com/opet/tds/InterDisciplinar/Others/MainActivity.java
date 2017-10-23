package br.com.opet.tds.InterDisciplinar.Others;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.opet.tds.InterDisciplinar.R;

/**
 * Created by rhayf on 24/05/2017.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectMainOpetion(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.btnInserir:
                intent = new Intent(this,InsertClubeActivity.class);
                break;
            case R.id.btnListar:
                intent = new Intent(this,ListClubeActivity.class);
                break;
        }
        if(intent != null){
            startActivity(intent);
        }
    }
}
