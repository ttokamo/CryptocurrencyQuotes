package by.overone.it.property_reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@PropertySource(value = "classpath:crypto-id.properties")
@Component
public class GetCryptoProperty {

    @Autowired
    private Environment environment;

    public String getProperty(String symbol) {
        return environment.getProperty(symbol);
    }
}
