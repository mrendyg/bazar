package com.andyg.bazar.service;

import com.andyg.bazar.persistence.model.ClienteEntity;
import com.andyg.bazar.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteEntity> listsCliente(){
        return clienteRepository.findAll();
    }

    public ClienteEntity getsIdCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public ClienteEntity createsCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }

    public ClienteEntity updatesCliente(Long id, ClienteEntity cliente){
        ClienteEntity updatedCliente = clienteRepository.findById(id).get();
        updatedCliente.setNombre(cliente.getNombre());
        updatedCliente.setApellido(cliente.getApellido());
        updatedCliente.setDni(cliente.getDni());
        return clienteRepository.save(updatedCliente);
    }

    public void deletesCliente(Long id){
        ClienteEntity deletedcliente = clienteRepository.findById(id).get();
        clienteRepository.delete(deletedcliente);
    }


}
