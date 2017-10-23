package br.com.opet.tds.InterDisciplinar.API;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;

import br.com.opet.tds.InterDisciplinar.R;

public class APIActivity extends Activity {

    TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        textInfo = (TextView) findViewById(R.id.textInfo);
        executeTask();
    }

    public void executeTask() {
        new APIConnection().execute();
    }

    private class APIConnection extends AsyncTask<Void, Void, String> {

        int contador;

        @Override
        public void onPreExecute(){


        }

        @Override
        public String doInBackground(Void... params){
            HttpURLConnection con = null;
            try {
                URL url = new URL("http://angeloportifolio.pe.hu/JSON2.json");
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);

                String resultado = Util.streamToString(con.getInputStream());
                return resultado;

            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                con.disconnect();
            }
            return null;

        }

        @Override
        public void onPostExecute(String s){
            textInfo.setText(s);


        }

    }
}