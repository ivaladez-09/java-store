package com.store.api.web.controllers;

import com.store.api.persistence.entity.Client;
import com.store.api.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/all")
    public @ResponseBody Iterable<Client> getAll(){
        return clientRepository.findAll();
    }

    @PostMapping("/create")
    public @ResponseBody String createClient(@RequestParam String firstName,
                                             @RequestParam String lastName,
                                             @RequestParam String email,
                                             @RequestParam Long phoneNumber){
        Client client = new Client(firstName, lastName, email, phoneNumber);
        try {
            clientRepository.save(client);
            return "Client saved";
        }catch (Exception e) {
            return "Client was NOT saved";
        }
    }
}
