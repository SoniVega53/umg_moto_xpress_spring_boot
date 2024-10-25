package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.motoxpress.umg.motoxpress.model.entity.MarcaModeloEntity;
import com.motoxpress.umg.motoxpress.service.MarcaModeloService;

@RestController
@RequestMapping("/proyecto/marcaModelo")
public class MarcaModeloController {

    @Autowired
    private MarcaModeloService marcaModeloService;

    @GetMapping
    public List<MarcaModeloEntity> getAllMarcaModelos() {
        return marcaModeloService.getDataList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaModeloEntity> getMarcaModeloById(@PathVariable Long id) {
        MarcaModeloEntity marcaModelo = marcaModeloService.getFindUncle(id);
        if (marcaModelo != null) {
            return ResponseEntity.ok(marcaModelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MarcaModeloEntity createMarcaModelo(@RequestBody MarcaModeloEntity marcaModelo) {
        return marcaModeloService.createOrUpdate(marcaModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaModeloEntity> updateMarcaModelo(@PathVariable Long id, @RequestBody MarcaModeloEntity marcaModelo) {
        MarcaModeloEntity existingMarcaModelo = marcaModeloService.getFindUncle(id);
        if (existingMarcaModelo != null) {
            marcaModelo.setId(id);
            return ResponseEntity.ok(marcaModeloService.createOrUpdate(marcaModelo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarcaModelo(@PathVariable Long id) {
        MarcaModeloEntity marcaModelo = marcaModeloService.getFindUncle(id);
        if (marcaModelo != null) {
            marcaModeloService.deleteFind(marcaModelo);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
