package com.project.gestion_de_inventario.repository;

import com.project.gestion_de_inventario.model.Inventario;

import org.springframework.data.jpa.repository.JpaRepository;

;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long>{
    List<Inventario> findByNombreDeProducto(String nombreDeProducto);


}