/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.ingsf.abarroteria.service;

import javafx.collections.ObservableList;
import main.java.com.ingsf.abarroteria.model.Producto;
import main.java.com.ingsf.abarroteria.repository.ProductoRepository;

/**
 *
 * @author informatica
 */
public class DashboardService {
    private final ProductoRepository productoRepository;

    public DashboardService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public ObservableList<Producto> findProducto(){
        if(productoRepository.findAll() == null){
            throw new RuntimeException("sin productos");
        }
        return productoRepository.findAll();
    }
}
