package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.services.ClientService;

import jakarta.servlet.Servlet;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> clients = clientService.findALL();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping(value = "/{idNumber}")
    public ResponseEntity<Client> findaByIdNumber(@PathVariable String idNumber){
        Client client = clientService.findByIdNumber(idNumber);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable String id, @RequestBody Client client){
        client = clientService.Update(id, client);
        return ResponseEntity.ok().body(client);
    }

}
