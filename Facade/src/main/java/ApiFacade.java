import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject; // add Maven dependency for JSON.simple
import org.json.simple.parser.JSONParser; // add Maven dependency for JSON.simple
import org.json.simple.parser.ParseException;

public class ApiFacade implements Facade {

    @Override
    public Map<String, String> getAttributeValueFromJson(String apiUrl, String attributeName)
            throws IllegalArgumentException, IOException {

        String jsonResponse = getJsonFromApi(apiUrl);
        return extractDataFromJson(jsonResponse, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        HttpURLConnection connection = setUpConnection(apiUrl);

        return buildContents(connection);
    }

    private Map<String, String> extractDataFromJson(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }

            Map<String, String> result = new HashMap<>();
            if (value instanceof JSONObject) {
                JSONObject valueObj = (JSONObject) value;
                for (Object key : valueObj.keySet()) {
                    result.put(key.toString(), valueObj.get(key).toString());
                }
            } else {
                result.put(attributeName, value.toString());
            }
            return result;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON", e);
        }
    }

    private HttpURLConnection setUpConnection(String apiUrl) throws IOException {
        URL url;
        try {
            url = URI.create(apiUrl).toURL();
        } catch (IllegalArgumentException e) {
            throw new IOException("Invalid URL: " + apiUrl, e);
        }
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return con;
    }

    private String buildContents(HttpURLConnection connection) throws IOException {
        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new IOException("HTTP error code: " + status);
        }

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        )) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            connection.disconnect();
        }
    }
}
