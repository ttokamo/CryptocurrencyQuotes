package by.overone.it.dto;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Quote {
    private String symbol;
    private String price;
    private String percent_change;

    @Override
    public String toString() {
        return "Symbol: " + symbol + "\n"
                + "Price: " + price + " USD";
    }
}
