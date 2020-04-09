package com.adsi.bike.web.rest;

import com.adsi.bike.domain.Client;
import com.adsi.bike.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientResource {

    @Autowired
    IClientService clientService;

    @PostMapping("/client")
    public ResponseEntity create(@RequestBody Client client){
        return clientService.create(client);
    }

    @GetMapping("/client")
    public Iterable<Client> read(){
        return clientService.read();
    }

    @DeleteMapping("/client/{id}")
    public void delete(@PathVariable Integer id){
        clientService.delete(id);
    }

    @PutMapping("/client")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @GetMapping("/client/{id}")
    public Optional<Client> getById(@PathVariable Integer id){
        return clientService.getById(id);
    }

    @GetMapping("/client/search")
    public ResponseEntity search (@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "email", required = false) String email,
                                  @RequestParam(value = "document", required = false) String documentNumber){
        return clientService.search(name, email, documentNumber);
    }

}
