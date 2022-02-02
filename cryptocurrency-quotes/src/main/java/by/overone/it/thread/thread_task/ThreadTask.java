package by.overone.it.thread.thread_task;

import by.overone.it.pojo.User;
import by.overone.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@Component
@Scope("prototype")
public class ThreadTask {

    @Autowired
    private UserService userService;

    public void doTask(String symbol, String price) {
        List<User> userList = userService.getUsersByCryptoSymbol(symbol);
        if (!userList.isEmpty()) {
            double newPrice = Double.parseDouble(price);
            for (User user : userList) {
                if (comparePrice(Double.parseDouble(user.getPrice()), newPrice)) {
                    LOGGER.warn(user.getNickname() + ": " + user.getCryptoSymbol() + " price changed by 1%. New price: " + user.getPrice() + " USD");
                    userService.updateCryptoPrice(String.valueOf(newPrice), user.getId());
                }
            }
        }
    }

    private boolean comparePrice(double oldPrice, double newPrice) {
        double difference = newPrice - oldPrice;
        double onePercentOfTheOldPrice = oldPrice / 100;
        return difference >= onePercentOfTheOldPrice;
    }
}
