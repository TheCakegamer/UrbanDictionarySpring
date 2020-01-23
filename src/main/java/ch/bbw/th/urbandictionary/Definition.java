package ch.bbw.th.urbandictionary;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Definition {

    public String term;
    public String definition;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return getDefinitionfromAPI().getList()[0].getDefinition();

    }

    public DefinitionList getDefinitionfromAPI(){
        DefinitionList definition = null;
        try {
            StringBuilder url = new StringBuilder("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=" + this.term);
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
        return definition;

    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
