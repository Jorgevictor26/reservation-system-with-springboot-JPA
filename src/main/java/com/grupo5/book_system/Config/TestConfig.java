package com.grupo5.book_system.Config;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.entities.enums.RoomStatus;
import com.grupo5.book_system.entities.enums.RoomType;
import com.grupo5.book_system.repositories.ClientRepository;
import com.grupo5.book_system.repositories.RoomRepository;
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
    @Autowired
    RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        Client client = new Client(null, "005452465BA041", "Jorge", "Victor", "jv@gmail", "930296746");
        Client client1 = new Client(null ,"005452465BA040", "Helena", "Panzo", "hp@gmail", "9000000");
        Client client2 = new Client(null, "005452465BA041", "Lucio", "Victorino", "lv@gmail", "930296746");

        Room room = new Room(null, RoomType.STANDARD, 25000.0, 3, RoomStatus.ACTIVE);
        Room room1 = new Room(null, RoomType.STANDARD, 28000.0, 3, RoomStatus.MAINTENANCE);
        Room room2 = new Room(null, RoomType.DELUXE, 29000.0, 4, RoomStatus.INACTIVE);

        roomRepository.saveAll(Arrays.asList(room, room1, room2));
        clientRepository.saveAll(Arrays.asList(client, client1, client2));
    }
}
