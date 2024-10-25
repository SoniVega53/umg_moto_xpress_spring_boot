package com.motoxpress.umg.motoxpress.controller;

import com.motoxpress.umg.motoxpress.model.entity.TipoEstadoMotocicletaEntity;
import com.motoxpress.umg.motoxpress.service.TipoEstadoMotocicletaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/tipoestado")
public class TipoEstadoMotocicletaController {

    @Autowired
    private TipoEstadoMotocicletaService service;

    
    @GetMapping
    public ResponseEntity<List<TipoEstadoMotocicletaEntity>> getAll() {
        List<TipoEstadoMotocicletaEntity> list = service.getDataList();
        return ResponseEntity.ok(list);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<TipoEstadoMotocicletaEntity> getById(@PathVariable Long id) {
        TipoEstadoMotocicletaEntity entity = service.getFindUncle(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }
}
