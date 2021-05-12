package com.store.api.web.controllers;

import com.store.api.persistence.entity.Client;
import com.store.api.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class StoreController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/greeting")
    public String greeting(){
        return "Hello World";
    }

    @GetMapping("/client")
    public @ResponseBody Iterable<Client> getAllClients(){
        return clientRepository.findAll();
    }

    // /api/clothes/client/add?firsName=Ivan&lastName=Valadez&email=ivaladez@gmail.com&cellphone=3313418502
    @PostMapping("client/add")
    public @ResponseBody String createUser(@RequestParam String firstName,
                                           @RequestParam String lastName,
                                           @RequestParam String email,
                                           @RequestParam Long cellphone){
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhoneNumber(cellphone);

        clientRepository.save(client);
        return "Saved";
    }
}
