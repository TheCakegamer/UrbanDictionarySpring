package ch.bbw.th.urbandictionary.gif;

import ch.bbw.th.urbandictionary.definition.DefinitionList;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Gif {
    private Data[] data;
    private String term;

    public Data[] getData() {
        initiateGif(term);
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public void initiateGif(String term) {
        Gif gif = null;
        this.term = term;
        try {
            StringBuilder url = new StringBuilder("https://api.giphy.com/v1/gifs/search?api_key=t4OPZDGW4I9Ghz1jcOD1DXIgiuoLyCYF&q=" + term.replaceAll("\\s+", "+") + "&limit=1&offset=0");
            HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();

            int respCode = conn.getResponseCode();
            if (respCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                Gson gson = new Gson();
                gif = gson.fromJson(reader, Gif.class);
            } else {
                System.err.println("Response Problem: " + conn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (gif != null) {
            this.data = gif.data;
        }
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }

}
