/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.ingsf.abarroteria.repository;

import javafx.collections.ObservableList;
import main.java.com.ingsf.abarroteria.config.DataBaseConnection;
import main.java.com.ingsf.abarroteria.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
/**
 *
 * @author informatica
 */
public class ProductoRepository {
    
    public ObservableList<Producto>findAll(){
        String sql = "select * from productos";
        try(PreparedStatement pstm = DataBaseConnection.getDataBaseConnection().prepareCall(sql)){
        ResultSet rs = pstm.executeQuery();
        ObservableList<Producto> lista = FXCollections.observableArrayList();
        while(rs.next()){
            lista.add(new Producto(
            rs.getString("id_productos"),
            rs.getString("nombre_producto"),
            rs.getInt("stock"),
            rs.getBigDecimal("precio")
            ));
        }
        return lista;
        }catch(SQLException e){
                throw new RuntimeException("error en la consulta");
           }
                   }
    }
    

