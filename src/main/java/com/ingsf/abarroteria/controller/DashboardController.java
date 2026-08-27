/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main.java.com.ingsf.abarroteria.controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.com.ingsf.abarroteria.model.Producto;
import main.java.com.ingsf.abarroteria.service.DashboardService;
import main.java.com.ingsf.abarroteria.util.SceneManager;

/**
 * FXML Controller class
 *
 * @author informatica
 */
public class DashboardController implements Initializable {
    private DashboardService dashboardService;
    private SceneManager sceneManager;
    @FXML
    private TableView<Producto> tableProducto;
    @FXML
    private TableColumn<Producto, String> tableColumIdProducto;
    @FXML
    private TableColumn<Producto, String> tableColumNombreProducto;
    @FXML
    private TableColumn<Producto, Integer> tableColumStock;
    @FXML
    private TableColumn<Producto, BigDecimal> tableColumPrecio;
    
    public DashboardController(DashboardService dashboardService, SceneManager sceneManager){
        this.dashboardService = dashboardService;
        this.sceneManager = sceneManager;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void handleLoadDataTableView(){
        tableColumIdProducto.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        tableColumNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        tableColumStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableColumPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }
}
