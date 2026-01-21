package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findALL();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findaByIdNumber(@PathVariable Long id) {
        Client client = clientService.findByIdNumber(id);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        client = clientService.Update(id, client);
        return ResponseEntity.ok().body(client);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client) {
        client = clientService.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

}
