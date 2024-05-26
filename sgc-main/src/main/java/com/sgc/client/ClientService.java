package com.sgc.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sgc.ResourceNotFoundException;

@Service
public class ClientService {
    
    
    @Autowired
    public ClientRepository clientRepository;


    @Transactional(readOnly = true)
    public Page<Client> findAllPage(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }
    

    @Transactional
    public Client insert(Client client) {
        return clientRepository.save(client);
    }
    
    @Transactional
    public Client update(Long id, Client client) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        existingClient.setName(client.getName());
        existingClient.setPhone(client.getPhone());
        existingClient.setAddress(client.getAddress());
        return clientRepository.save(existingClient);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found");
        }
        try {
            clientRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Client is in use");
        }
    }
}
