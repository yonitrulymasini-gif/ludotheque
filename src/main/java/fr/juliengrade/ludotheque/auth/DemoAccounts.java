package fr.juliengrade.ludotheque.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DemoAccounts {
    @Bean
        CommandLineRunner seedUsers(
            AppUserRepository repository,
            PasswordEncoder encoder
        ) {
            return args -> {
                if (repository.findByEmail("admin@ludo.test").isEmpty()) {
                repository.save(new AppUser(
                "admin@ludo.test", encoder.encode("Admin123!"), "ADMIN"
                ));
                }
                if (repository.findByEmail("membre@ludo.test").isEmpty()) {
                repository.save(new AppUser(
                "membre@ludo.test", encoder.encode("Membre123!"), "MEMBER"
                ));
            }
        };
    }
}