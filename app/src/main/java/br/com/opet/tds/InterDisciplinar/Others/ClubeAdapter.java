package br.com.opet.tds.InterDisciplinar.Others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.opet.tds.InterDisciplinar.R;

/**
 * Created by rhayf on 24/05/2017.
 */

public class ClubeAdapter extends ArrayAdapter<Clube> {
    private List<Clube> clubes;
    private int layout;

    public ClubeAdapter(Context context, int resource, List<Clube> clubes){
        super(context,resource,clubes);
        this.clubes = clubes;
        layout = resource;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent){
        View localView = contentView;

        if(localView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            localView = inflater.inflate(layout,null);
        }

        Clube clube = clubes.get(position);

        if(clube != null){
            TextView textID = (TextView) localView.findViewById(R.id.textID);
            TextView textNome = (TextView) localView.findViewById(R.id.textNome);
            TextView textCidade = (TextView) localView.findViewById(R.id.textCidade);


            if(textID != null){
                textID.setText(String.valueOf(clube.getID()));
            }
            if(textNome != null){
                textNome.setText(clube.getNome());
            }
            if(textCidade != null){
                textCidade.setText(clube.getCidade());
            }

        }
        return localView;
    }
}
