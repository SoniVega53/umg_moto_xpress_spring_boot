package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.motoxpress.umg.motoxpress.model.entity.ModeloEntity;
import com.motoxpress.umg.motoxpress.service.ModeloService;

@RestController
@RequestMapping("/proyecto/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    
    @GetMapping
    public List<ModeloEntity> getAllModelos() {
        return modeloService.getDataList();
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<ModeloEntity> getModeloById(@PathVariable Long id) {
        ModeloEntity modelo = modeloService.getFindUncle(id);
        if (modelo != null) {
            return ResponseEntity.ok(modelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  
    @PostMapping
    public ResponseEntity<ModeloEntity> createModelo(@RequestBody ModeloEntity modelo) {
        ModeloEntity nuevoModelo = modeloService.createOrUpdate(modelo);
        return ResponseEntity.ok(nuevoModelo);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloEntity> updateModelo(@PathVariable Long id, @RequestBody ModeloEntity modelo) {
        modelo.setId(id);
        ModeloEntity updatedModelo = modeloService.createOrUpdate(modelo);
        return ResponseEntity.ok(updatedModelo);
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        ModeloEntity modelo = modeloService.getFindUncle(id);
        if (modelo != null) {
            modeloService.deleteFind(modelo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
