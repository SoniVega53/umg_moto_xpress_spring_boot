package com.motoxpress.umg.motoxpress.controller;

import com.motoxpress.umg.motoxpress.model.entity.TipoEstadoReservacionEntity;
import com.motoxpress.umg.motoxpress.service.TipoEstadoReservacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/tipoestadoreservacion")
public class TipoEstadoReservacionController {

    @Autowired
    private TipoEstadoReservacionService service;

    
    @GetMapping
    public ResponseEntity<List<TipoEstadoReservacionEntity>> getAll() {
        List<TipoEstadoReservacionEntity> list = service.getDataList();
        return ResponseEntity.ok(list);
    }

 
    @GetMapping("/{id}")
    public ResponseEntity<TipoEstadoReservacionEntity> getById(@PathVariable Long id) {
        TipoEstadoReservacionEntity entity = service.getFindUncle(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }
}
