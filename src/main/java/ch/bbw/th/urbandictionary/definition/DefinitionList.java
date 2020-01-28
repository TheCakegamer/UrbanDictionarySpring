package ch.bbw.th.urbandictionary.definition;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefinitionList
{
    private DefinitionObject[] list;
    private String term;

    public DefinitionList(String term) {
        DefinitionList definition = null;
        if (term == null){
            term = "";
        }
        try {
            StringBuilder url = new StringBuilder("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=" + term.replaceAll("\\s+","+"));
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
            conn.setRequestProperty("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com");
            conn.setRequestProperty("x-rapidapi-key", "77c058c434msha022573d7829d07p14fae5jsn784f79a2cae5");

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                definition = gson.fromJson(reader, DefinitionList.class);
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        if (definition != null) {
            this.list = definition.list;
            this.term = term;
        }
    }

    public DefinitionObject[] getList() {
        return list;
    }

    public void setList (DefinitionObject[] list)
    {
        this.list = list;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [list = "+list+"]";
    }
}
