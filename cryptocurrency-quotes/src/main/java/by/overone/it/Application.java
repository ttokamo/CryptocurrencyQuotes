package by.overone.it;

import by.overone.it.thread.QuoteBTCThread;
import by.overone.it.thread.QuoteETHThread;
import by.overone.it.thread.QuoteSOLThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("by.overone.it.pojo")
@ComponentScan("by.overone.it")
@EnableJpaRepositories("by.overone.it.repository")
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            @Qualifier("BTC") Thread BTCThread,
            @Qualifier("ETH") Thread ETHThread,
            @Qualifier("SOL") Thread SOLThread) {
        return args -> {
            BTCThread.start();
            ETHThread.start();
            SOLThread.start();
        };
    }

    @Bean(name = "BTC")
    Thread BTCThread(@Autowired QuoteBTCThread quoteBTCThread) {
        return new Thread(quoteBTCThread);
    }

    @Bean(name = "ETH")
    Thread ETHThread(@Autowired QuoteETHThread quoteETHThread) {
        return new Thread(quoteETHThread);
    }

    @Bean(name = "SOL")
    Thread SOLThread(@Autowired QuoteSOLThread quoteSOLThread) {
        return new Thread(quoteSOLThread);
    }
}
