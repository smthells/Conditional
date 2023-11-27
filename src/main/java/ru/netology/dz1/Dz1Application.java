package ru.netology.dz1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import ru.netology.dz1.profile.DevProfile;
import ru.netology.dz1.profile.ProductionProfile;
import ru.netology.dz1.profile.SystemProfile;

@SpringBootApplication
public class Dz1Application {

    public static void main(String[] args) {
        SpringApplication.run(Dz1Application.class, args);
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

}
