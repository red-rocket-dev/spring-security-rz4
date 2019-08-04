package pl.sda.springsecurity.sectest.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.sda.springsecurity.sectest.model.UserEntity;
import pl.sda.springsecurity.sectest.repository.UserRepository;

@Configuration
public class InitialDataConfiguration {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InitialDataConfiguration(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args -> {
            if (userRepository.findByLogin("myLogin") == null) {
                System.out.println("HELLO WORLD");
                UserEntity user = new UserEntity();
                user.setLogin("myLogin");
                user.setPassword(passwordEncoder.encode("password"));
                userRepository.save(user);
            }
        });
    }
}
