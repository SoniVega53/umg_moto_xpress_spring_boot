package com.motoxpress.umg.motoxpress.controller;

import com.motoxpress.umg.motoxpress.model.entity.ZonaGeograficaEntity;
import com.motoxpress.umg.motoxpress.service.ZonaGeograficaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/zonageografica")
public class ZonaGeograficaController {

    @Autowired
    private ZonaGeograficaService service;

    // Obtener todas las zonas geográficas
    @GetMapping
    public ResponseEntity<List<ZonaGeograficaEntity>> getAll() {
        List<ZonaGeograficaEntity> list = service.getDataList();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ZonaGeograficaEntity> getById(@PathVariable Long id) {
        ZonaGeograficaEntity entity = service.getFindUncle(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }


    @PostMapping
    public ResponseEntity<ZonaGeograficaEntity> create(@RequestBody ZonaGeograficaEntity value) {
        ZonaGeograficaEntity createdEntity = service.createOrUpdate(value);
        return ResponseEntity.status(201).body(createdEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZonaGeograficaEntity> update(@PathVariable Long id, @RequestBody ZonaGeograficaEntity value) {
        value.setId(id); // Set the ID for the entity
        ZonaGeograficaEntity updatedEntity = service.createOrUpdate(value);
        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ZonaGeograficaEntity entity = service.getFindUncle(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteFind(entity);
        return ResponseEntity.noContent().build();
    }
}
