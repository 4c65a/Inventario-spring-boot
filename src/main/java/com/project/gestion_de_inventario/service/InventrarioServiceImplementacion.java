package com.project.gestion_de_inventario.service;


import com.project.gestion_de_inventario.model.Inventario;
import com.project.gestion_de_inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventrarioServiceImplementacion implements InverntarioService{


    @Autowired
    private InventarioRepository repository;


    @Override
    public List<Inventario> getAllInventario() {
        return repository.findAll();
    }

    @Override
    public List<Inventario> getByNombre(String nombreDeProducto) {
        return repository.findByNombreDeProducto(nombreDeProducto);
    }

    @Override
    public void updateInvetario(Inventario inventario) {
        repository.save(inventario);

    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }


    @Override
    public Inventario addInventory(Inventario inventario) {
        return repository.save(inventario);
    }

    @Override
    public Optional<Inventario> seachById(Long id) {
        return repository.findById(id);
    }

}
