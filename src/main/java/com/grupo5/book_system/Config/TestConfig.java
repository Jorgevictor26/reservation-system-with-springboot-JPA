package com.grupo5.book_system.Config;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        Client client = new Client("005452465BA041", "Jorge", "Victor", "jv@gmail", "930296746");
        Client client1 = new Client("005452465BA040", "Helena", "Panzo", "hp@gmail", "9000000");
        Client client2 = new Client("005452465BA041", "Lucio", "Victorino", "lv@gmail", "930296746");


        clientRepository.saveAll(Arrays.asList(client, client1, client2));
    }
}
