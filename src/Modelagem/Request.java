import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;

public class Request {


        // Ex: "https://v6.exchangerate-api.com/v6/SEU_API_KEY/latest/BRL"
        public final Gson gson = new Gson();

        public MapGson getConversion(String coin) throws Exception {

            String API_URL = "https://v6.exchangerate-api.com/v6/a2e3c94871023107c91b07f3/latest/" + coin;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new Exception("Erro na API: " + response.body());
            }

            return gson.fromJson(response.body(),MapGson.class);
        }}

