package modules;

import com.google.gson.Gson;
import models.Converter;
import models.ConverterExchangeRateApi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class ApiConverterExchangeRateApi implements ApiConverter {

    @Override
    public Converter apiConverter(String origin, String destiny, String value) {
        DotEnv dotEnv = new DotEnv();
        final String API_KEY = dotEnv.getDotEnv("MY_ENV_APIKEY");
        final String API_URI = dotEnv.getDotEnv("MY_ENV_APIURI")
                .replace("[APIKEY]", API_KEY)
                .concat("/").concat(origin.toUpperCase(Locale.ROOT))
                .concat("/").concat(destiny.toUpperCase(Locale.ROOT))
                .concat("/").concat(value.toUpperCase(Locale.ROOT));

        try {
            URI linkURI = URI.create(API_URI);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(linkURI)
                    .build();

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ConverterExchangeRateApi jsonApi = new Gson().fromJson(response.body(), ConverterExchangeRateApi.class);
            Converter apiConverter = new Converter(jsonApi, value);

            if (apiConverter.toString().isEmpty()) {
                System.out.println("Problema com o acesso a ExchangeRate-API.");
            }
            return apiConverter;
        } catch (Exception e) {
            System.out.println("Problema com o acesso a ExchangeRate-API.");
//            System.out.println("Error Message:\n" + e.getCause());
            return null;
        }

    }
}
