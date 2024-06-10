package com.videoplatform.videoplatform.seeders;


import com.videoplatform.videoplatform.enums.Role;
import com.videoplatform.videoplatform.models.User;
import com.videoplatform.videoplatform.repositories.UserRepository;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeedDataServiceImpl implements SeedDataService{
    Dotenv dotenv = Dotenv.load();
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void seedAdministrator() {

        User administrator = User.builder()
                .email(dotenv.get("ADMIN_EMAIL"))
                .password(passwordEncoder.encode(dotenv.get("ADMIN_PASSWORD")))
                .role(Role.ADMINISTRATOR)
                .build();

        userRepository.save(administrator);
    }
}
