package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.motoxpress.umg.motoxpress.model.entity.InventarioEntity;
import com.motoxpress.umg.motoxpress.service.InventarioService;

@RestController
@RequestMapping("/proyecto/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<InventarioEntity> getAllInventario() {
        return inventarioService.getDataList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioEntity> getInventarioById(@PathVariable Long id) {
        InventarioEntity inventario = inventarioService.getFindUncle(id);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public InventarioEntity createInventario(@RequestBody InventarioEntity inventario) {
        return inventarioService.createOrUpdate(inventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioEntity> updateInventario(@PathVariable Long id, @RequestBody InventarioEntity inventario) {
        InventarioEntity existingInventario = inventarioService.getFindUncle(id);
        if (existingInventario != null) {
            inventario.setId(id);
            return ResponseEntity.ok(inventarioService.createOrUpdate(inventario));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        InventarioEntity inventario = inventarioService.getFindUncle(id);
        if (inventario != null) {
            inventarioService.deleteFind(inventario);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
