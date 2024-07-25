package com.andyg.bazar.service;

import com.andyg.bazar.persistence.model.ProductoEntity;
import com.andyg.bazar.persistence.model.VentaEntity;
import com.andyg.bazar.persistence.repository.ProductoRepository;
import com.andyg.bazar.persistence.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //se debe sumar la totalidad de la venta segun los precios de los productos
    public VentaEntity createsVenta(VentaEntity venta) {
        List<ProductoEntity> productos = venta.getProductos(); // Asumiendo que venta tiene una lista de productos
        int sumatotal = 0;

        for (ProductoEntity producto : productos) {
            sumatotal += producto.getPrecio();
        }

        venta.setTotal(sumatotal);
        venta.setFecha_venta(LocalDateTime.now());
        return ventaRepository.save(venta);
    }

    public VentaEntity updatesVenta(Long id, VentaEntity venta){
        VentaEntity updatedVenta = ventaRepository.findById(id).get();
        updatedVenta.setCliente(venta.getCliente());
        updatedVenta.setProductos(venta.getProductos());
        return ventaRepository.save(updatedVenta);
    }

    public void deletesVenta(Long id){
        VentaEntity deletedVenta = ventaRepository.findById(id).get();
        ventaRepository.delete(deletedVenta);
    }

}
