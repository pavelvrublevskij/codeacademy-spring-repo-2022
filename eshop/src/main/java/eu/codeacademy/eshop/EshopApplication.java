package eu.codeacademy.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class EshopApplication {

    public static void main(String[] args) {
        ConfigurableEnvironment envConf = new StandardEnvironment();
        envConf.addActiveProfile("dev");

        SpringApplication app = new SpringApplication(EshopApplication.class);
        app.setEnvironment(envConf);
        app.run(args);

        //SpringApplication.run(EshopApplication.class, args);
    }

}
