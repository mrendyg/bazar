package com.andyg.bazar.controller;

import com.andyg.bazar.persistence.model.ProductoEntity;
import com.andyg.bazar.persistence.repository.ProductoRepository;
import com.andyg.bazar.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoEntity> listaProductos(){
        return productoService.listsProductos();
    }

    @GetMapping("/list/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductoEntity getIdProducto(@PathVariable Long id){
        return productoService.getsIdProducto(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoEntity createProducto(@RequestBody ProductoEntity producto){
        return productoService.createsProducto(producto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductoEntity updateProducto(@RequestBody ProductoEntity producto,
                                         @PathVariable Long id){
        return productoService.updatesProducto(id, producto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable Long id){
        productoService.deletesProducto(id);
    }

    //BUSQUEDA DE PRODUCTOS QUE 5 O MENOS STOCK
    @GetMapping("/list/stock_bajo")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoEntity> getBajoStock(){
        return productoService.getStockBajo();
    }

}
