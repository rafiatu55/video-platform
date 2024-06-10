package com.videoplatform.videoplatform.seeders;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeders implements CommandLineRunner {
    private final SeedDataService seedDataService;

    @Override
    public void run(String... args) throws Exception {
        seedDataService.seedAdministrator();
    }
}
