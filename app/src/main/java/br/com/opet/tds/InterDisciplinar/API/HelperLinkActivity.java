package br.com.opet.tds.InterDisciplinar.API;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.opet.tds.InterDisciplinar.R;

public class HelperLinkActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_link);


    Button btn = (Button) findViewById(R.id.btn_clickme);
        btn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myWebLink.setData(Uri.parse("https://github.com/RhayFS7/AppInterDisciplinar2"));
            startActivity(myWebLink);
        }
    });
}
}


