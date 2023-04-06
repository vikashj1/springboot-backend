package net.vikash.springbootproject.controller;

import net.vikash.springbootproject.exception.ResourceNotFoundException;
import net.vikash.springbootproject.model.Client;
import net.vikash.springbootproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    // Fetch all clients.
    @GetMapping("/clients")
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    //  Create a new client.
    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client){
        return clientRepository.save(client);
    }
    // Fetch a specific client by ID.
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client = clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        return ResponseEntity.ok(client);
    }
    // Update a client's information
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setAddress(clientDetails.getAddress());
        client.setContactNumber(clientDetails.getContactNumber());
        client.setDateOfBirth(clientDetails.getDateOfBirth());
        client.setEmailId(clientDetails.getEmailId());

        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }
    // Delete a client.
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteClient(@PathVariable Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client doesn't exist with the given ID  : "+ id));
        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
