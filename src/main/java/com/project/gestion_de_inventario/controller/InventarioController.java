package com.project.gestion_de_inventario.controller;

import com.project.gestion_de_inventario.model.Inventario;
import com.project.gestion_de_inventario.service.InventrarioServiceImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class InventarioController {

    @Autowired
    private InventrarioServiceImplementacion service;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return  ResponseEntity.ok("Tets de controlador ");
    }



    @GetMapping("/inventario")
    public ResponseEntity<List<Inventario>> getAllInventario(){
        List<Inventario> inventarios = service.getAllInventario();
        if (inventarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventarios, HttpStatus.OK);
    }

    @GetMapping("/inventario/{nombreDeProducto}")
    public  ResponseEntity<List<Inventario>> getByNombre(@PathVariable String nombreDeProducto){
        List<Inventario> inventarios = service.getByNombre(nombreDeProducto);
        if (inventarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inventarios, HttpStatus.OK);
    }


    @PutMapping("/update")
    public void updateInventario(Inventario inventario){
       service.updateInvetario(inventario);
    }

    @PutMapping("/add")
    public  ResponseEntity<Inventario> addInventario(@Valid  Inventario inventario){
        return ResponseEntity.ok(service.addInventory(inventario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> deleteById(@PathVariable long id) {
        Optional<Inventario> product = service.seachById(id);
        if (!product.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("errorMessage", "El producto con el  " + id + " no existe");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
