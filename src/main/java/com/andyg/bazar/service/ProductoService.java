package com.andyg.bazar.service;

import com.andyg.bazar.persistence.model.ProductoEntity;
import com.andyg.bazar.persistence.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<ProductoEntity> listsProductos(){
        return productoRepository.findAll();
    }

    public ProductoEntity getsIdProducto(Long id){
        return productoRepository.findById(id).orElse(null);
    }

    public ProductoEntity createsProducto(ProductoEntity producto){
        return productoRepository.save(producto);
    }

    public  ProductoEntity updatesProducto(Long id, ProductoEntity producto){
        ProductoEntity updatedProducto = productoRepository.findById(id).get();
        updatedProducto.setNombre(producto.getNombre());
        updatedProducto.setMarca(producto.getMarca());
        updatedProducto.setPrecio(producto.getPrecio());
        updatedProducto.setStock(producto.getStock());
        return productoRepository.save(updatedProducto);
    }

    public void deletesProducto(Long id){
        ProductoEntity deletedProducto = productoRepository.findById(id).get();
        productoRepository.delete(deletedProducto);
    }

    //Stock bajo 5
    public List<ProductoEntity> getStockBajo(){
        int stockBajo = 5;

        List<ProductoEntity> listProductos = this.listsProductos();
        List<ProductoEntity> listaStockBajo = new ArrayList<ProductoEntity>();

        for(ProductoEntity producto: listProductos){
            if(producto.getStock() <= stockBajo){
                listaStockBajo.add(producto);
            }
        }
        return listaStockBajo;
    }
}
