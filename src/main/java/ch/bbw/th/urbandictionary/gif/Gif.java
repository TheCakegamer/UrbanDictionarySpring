package ch.bbw.th.urbandictionary.gif;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Gif {
    private Data[] data;
    private String term;
    private Data first;

    public Data[] getData() {
        return data;
    }

    public Data getFirst(){
        return getData()[0];
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public Gif(String term) {
        if (term == null){
            term = "";
        }
        Gif gif = null;
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
            this.term = term;
            this.data = gif.data;
        }
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + Arrays.toString(data) + "]";
    }

}
