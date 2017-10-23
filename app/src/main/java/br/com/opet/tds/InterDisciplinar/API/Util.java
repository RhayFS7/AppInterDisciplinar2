package br.com.opet.tds.InterDisciplinar.API;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import br.com.opet.tds.InterDisciplinar.Others.Clube;

/**
 * Created by Gustavo on 24/05/2017.
 */
public class Util {
    /**
     *Lê um arquivo da web via HTTP e converte o mesmo em String.
     *@param //inputStream Stream do arquivo local no aplicativo
     *@return O arquivo convertido em String.
     */

    public static String streamToString(InputStream is){
        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String webToString(InputStream inputStream) {
        InputStream localStream = inputStream;
        String localString = "";
        Writer writer = new StringWriter();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(localStream, "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                line = reader.readLine();
            }
            localString = writer.toString();
            writer.close();
            reader.close();
            localStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return localString;
    }

    public static String convertClubetoJSON(Clube clube){
        JSONObject mainObject = new JSONObject();
        try {
            mainObject.put("sala",clube.getNome());
            mainObject.put("descricao",clube.getCidade());


            return mainObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Clube> convertJSONtoClube(String jsonFile){
        List<Clube> clubes = new ArrayList<>();
        try {
            JSONArray mainObject = new JSONArray(jsonFile);

            for(int i = 0; i < mainObject.length(); i++){
                Clube novoClube = new Clube();
                JSONObject localObj = mainObject.getJSONObject(i);
                long id = localObj.getLong("id");
                String nome = localObj.getString("sala");
                String cidade = localObj.getString("descricao");

                novoClube.setID(id);
                novoClube.setNome(nome);
                novoClube.setCidade(cidade);

                clubes.add(novoClube);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clubes;
    }

    public static String getStatusFromJSON(String json){
        try {
            return new JSONObject(json).getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
