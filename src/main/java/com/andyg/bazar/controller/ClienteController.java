package com.andyg.bazar.controller;

import com.andyg.bazar.persistence.model.ClienteEntity;
import com.andyg.bazar.persistence.repository.ClienteRepository;
import com.andyg.bazar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteEntity> listCliente(){
        return clienteService.listsCliente();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteEntity getIdCliente(@PathVariable Long id){
        return clienteService.getsIdCliente(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntity createCliente (@RequestBody ClienteEntity cliente){
        return clienteService.createsCliente(cliente);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ClienteEntity updateCliente(@RequestBody ClienteEntity cliente,
                                       @PathVariable Long id){
        return clienteService.updatesCliente(id, cliente);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable Long id){
        clienteService.deletesCliente(id);
    }

}
