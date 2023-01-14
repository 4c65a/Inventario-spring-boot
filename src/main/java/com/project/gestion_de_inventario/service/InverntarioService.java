package com.project.gestion_de_inventario.service;


import com.project.gestion_de_inventario.model.Inventario;

import java.util.List;
import java.util.Optional;

public interface InverntarioService{


    public List<Inventario> getAllInventario();
    public List<Inventario> getByNombre(String nombre);
    public void updateInvetario(Inventario inventario);
    public void deleteById(long id);
    public Inventario addInventory(Inventario  inventario);

    public Optional<Inventario> seachById(Long id);
}
