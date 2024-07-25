package com.andyg.bazar.service;

import com.andyg.bazar.persistence.model.VentaEntity;
import com.andyg.bazar.persistence.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<VentaEntity> listsVentas(){
        return ventaRepository.findAll();
    }

    public VentaEntity getsIdVenta(Long id){
        return ventaRepository.findById(id).orElse(null);
    }

    public VentaEntity createsVenta(VentaEntity venta){
        venta.setFecha_venta(LocalDateTime.now());
        return ventaRepository.save(venta);
    }

    public VentaEntity updatesVenta(Long id, VentaEntity venta){
        VentaEntity updatedVenta = ventaRepository.findById(id).get();
        updatedVenta.setTotal(venta.getTotal());
        updatedVenta.setCliente(venta.getCliente());
        updatedVenta.setProductos(venta.getProductos());
        return ventaRepository.save(updatedVenta);
    }

    public void deletesVenta(Long id){
        VentaEntity deletedVenta = ventaRepository.findById(id).get();
        ventaRepository.delete(deletedVenta);
    }

}
