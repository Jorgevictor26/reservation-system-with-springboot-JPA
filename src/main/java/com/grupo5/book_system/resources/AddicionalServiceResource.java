package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.AddicionalService;
import com.grupo5.book_system.services.AddcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class AddicionalServiceResource {

    @Autowired
    AddcionalService addicionalService;

    @GetMapping
    public ResponseEntity<List<AddicionalService>> findAll() {
        List<AddicionalService> ServiceList = addicionalService.findALL();
        return ResponseEntity.ok().body(ServiceList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddicionalService> findaById(@PathVariable Long id) {
       AddicionalService service = addicionalService.findById(id);
        return ResponseEntity.ok().body(service);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddicionalService> update(@PathVariable Long id, @RequestBody AddicionalService service) {
        service = addicionalService.Update(id, service);
        return ResponseEntity.ok().body(service);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        addicionalService.DeletedById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<AddcionalService> insert(@RequestBody AddicionalService service) {
        service = addicionalService.insert(service);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(service.getId()).toUri();
        return ResponseEntity.created(uri).body(addicionalService);
    }

}
