package com.example.javafx;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIConnector {

    public JSONObject getJSONFromAPI() {
        try {
            URL url = new URL("https://dog.ceo/api/breeds/image/random");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder respString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    respString.append(scanner.nextLine());
                }

                JSONParser parse = new JSONParser();

                return (JSONObject) parse.parse(String.valueOf(respString));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
