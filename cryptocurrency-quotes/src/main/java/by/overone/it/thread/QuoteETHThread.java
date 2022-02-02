package by.overone.it.thread;

import by.overone.it.enums.AvailableCryptocurrencies;
import by.overone.it.json.JsonParser;
import by.overone.it.property_reader.GetCryptoProperty;
import by.overone.it.service.UserService;
import by.overone.it.thread.thread_task.ThreadTask;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuoteETHThread implements Runnable {

    @Autowired
    private ThreadTask threadTask;
    @Autowired
    private JsonParser jsonParser;
    @Autowired
    private GetCryptoProperty getCryptoProperty;
    private Map<String, String> map = new HashMap<>();

    @Autowired
    private UserService userService;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            map.put(AvailableCryptocurrencies.ETH.name(), getKeyForMap(AvailableCryptocurrencies.ETH.name()));
            threadTask.doTask(AvailableCryptocurrencies.ETH.name(), map.get(AvailableCryptocurrencies.ETH.name()));
            Thread.sleep(60000);
        }
    }

    private String getKeyForMap(String symbol) {
        return jsonParser.getPriceFromJson(getCryptoProperty.getProperty(symbol));
    }
}
