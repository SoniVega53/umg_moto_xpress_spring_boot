package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.motoxpress.umg.motoxpress.model.entity.MotocicletaEntity;
import com.motoxpress.umg.motoxpress.service.MotocicletaService;

@RestController
@RequestMapping("/proyecto/motocicleta")
public class MotocicletaController {

    @Autowired
    private MotocicletaService motocicletaService;

   
    @GetMapping
    public List<MotocicletaEntity> getAllMotocicletas() {
        return motocicletaService.getDataList();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<MotocicletaEntity> getMotocicletaById(@PathVariable Long id) {
        MotocicletaEntity motocicleta = motocicletaService.getFindUncle(id);
        if (motocicleta != null) {
            return ResponseEntity.ok(motocicleta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<MotocicletaEntity> createMotocicleta(@RequestBody MotocicletaEntity motocicleta) {
        MotocicletaEntity nuevaMotocicleta = motocicletaService.createOrUpdate(motocicleta);
        return ResponseEntity.ok(nuevaMotocicleta);
    }

 
    @PutMapping("/{id}")
    public ResponseEntity<MotocicletaEntity> updateMotocicleta(@PathVariable Long id, @RequestBody MotocicletaEntity motocicleta) {
        motocicleta.setId(id);
        MotocicletaEntity updatedMotocicleta = motocicletaService.createOrUpdate(motocicleta);
        return ResponseEntity.ok(updatedMotocicleta);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotocicleta(@PathVariable Long id) {
        MotocicletaEntity motocicleta = motocicletaService.getFindUncle(id);
        if (motocicleta != null) {
            motocicletaService.deleteFind(motocicleta);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
