package com.salesmanagement.salesmanagement.client.service;

import com.salesmanagement.salesmanagement.client.model.ClientModel;
import com.salesmanagement.salesmanagement.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public List<ClientModel> findAllClients() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ClientModel> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public ClientModel saveClient(ClientModel client) {
        return clientRepository.save(client);
    }

    @Transactional
    public ClientModel updateClient(Long id, ClientModel clientDetails) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setFirstName(clientDetails.getFirstName());
                    client.setLastName(clientDetails.getLastName());
                    client.setMobile(clientDetails.getMobile());
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}

