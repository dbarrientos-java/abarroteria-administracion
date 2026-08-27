/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.ingsf.abarroteria.model;

import java.math.BigDecimal;

/**
 *
 * @author informatica
 */
public class Producto {
    private String idProducto;
    private String nombreProducto;
    private int stock;
    private BigDecimal precio;

    public Producto(String idProducto, String nombreProducto, int stock, BigDecimal precio) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.precio = precio;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
     
    
}
