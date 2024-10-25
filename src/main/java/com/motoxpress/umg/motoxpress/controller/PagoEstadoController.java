package com.motoxpress.umg.motoxpress.controller;

import com.motoxpress.umg.motoxpress.model.entity.PagoEstadoEntity;
import com.motoxpress.umg.motoxpress.service.PagoEstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/pagoestado")
public class PagoEstadoController {

    @Autowired
    private PagoEstadoService service;

    @GetMapping
    public ResponseEntity<List<PagoEstadoEntity>> getAll() {
        List<PagoEstadoEntity> list = service.getDataList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoEstadoEntity> getById(@PathVariable Long id) {
        PagoEstadoEntity entity = service.getFindUncle(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }
}
