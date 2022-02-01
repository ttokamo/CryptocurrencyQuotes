package by.overone.it.json;

import by.overone.it.dto.Quote;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Component
@Scope("prototype")
public class JsonParser {

    @Autowired
    private Quote quote;

    @SneakyThrows
    public Quote getJsonFromUrl(String cryptoId) {
        final String PATH = "https://api.coinlore.net/api/ticker/?id=" + cryptoId;
        URL url = new URL(PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        JSONParser parser = new JSONParser();
        JSONArray quoteJsonArray = (JSONArray) parser.parse(reader);
        JSONObject quoteJsonObject = (JSONObject) quoteJsonArray.get(0);
        String symbol = (String) quoteJsonObject.get("symbol");
        String price = (String) quoteJsonObject.get("price_usd");
        quote.setSymbol(symbol);
        quote.setPrice(price);
        return quote;
    }
}
