package ch.bbw.th.urbandictionary.definition;

import ch.bbw.th.urbandictionary.gif.Gif;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefinitionList
{
    private DefinitionObject[] list;
    private String term = "";
    private DefinitionObject first;
    private Gif gif;

    public void initiateList() {
        DefinitionList definition = null;
        try {
            StringBuilder url = new StringBuilder("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=" + this.term.replaceAll("\\s+","+"));
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
            this.first = this.list[0];
        }
    }

    public DefinitionObject[] getList() {
        if(list == null) {
            initiateList();
        }
        return list;
    }

    public Gif getGif() {
        this.gif.initiateGif(this.term);
        return gif;
    }

    public void setGif(Gif gif) {
        this.gif = gif;
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

    public DefinitionObject getFirst() {
        return first;
    }

    public void setFirst(DefinitionObject first) {
        this.first = first;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [list = "+list+"]";
    }
}
