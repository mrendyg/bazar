package com.andyg.bazar.controller;

import com.andyg.bazar.persistence.model.VentaEntity;
import com.andyg.bazar.persistence.repository.VentaRepository;
import com.andyg.bazar.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<VentaEntity> listVentas(){
        return ventaService.listsVentas();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VentaEntity idGetVenta(@PathVariable Long id){
        return ventaService.getsIdVenta(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public VentaEntity createVenta(@RequestBody VentaEntity venta){
        return ventaService.createsVenta(venta);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public VentaEntity updateVenta(@PathVariable Long id, @RequestBody VentaEntity venta){
        return ventaService.updatesVenta(id, venta);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVenta(@PathVariable Long id){
        ventaService.deletesVenta(id);
    }

}
