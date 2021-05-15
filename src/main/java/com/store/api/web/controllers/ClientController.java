package com.store.api.web.controllers;

import com.store.api.persistence.entity.Client;
import com.store.api.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>((List<Client>) clientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> readClient(@PathVariable("id") int id){
        return clientRepository.findById(id)
                .map(client1 -> new ResponseEntity<>(client1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return new ResponseEntity<>(clientRepository.save(client), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            client.setId(id);
            return new ResponseEntity<>(clientRepository.save(client), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable("id") int id){
        boolean isClientDeleted = clientRepository.findById(id)
                .map(client -> {
                   clientRepository.delete(client);
                   return true;
                }).orElse(false);

        return (isClientDeleted) ? new ResponseEntity<>(HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
