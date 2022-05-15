package com.example.demo.controller;


import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public Iterable<Client> read() {
        return clientRepository.findAll();
    }

    @PostMapping("/clients")
    public Client create(@RequestBody Client client){
        return clientRepository.save(client);

    }
    @DeleteMapping("/clients/{id}")
    public Boolean delete(@PathVariable Long id){
        if (clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
    @PutMapping("/clients")
    public Client update(@RequestBody Client newClient){
        if (clientRepository.findById(newClient.getId()).isPresent()){
            Client oldClient = clientRepository.findById(newClient.getId()).get();
            oldClient.setName(newClient.getName());
            return clientRepository.save(oldClient);
        } else{
            return clientRepository.save(newClient);
        }

    }
}
