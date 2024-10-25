package com.motoxpress.umg.motoxpress.controller;

import com.motoxpress.umg.motoxpress.model.entity.TipoPagoEntity;
import com.motoxpress.umg.motoxpress.service.TipoPagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecto/tipopago")
public class TipoPagoController {

    @Autowired
    private TipoPagoService service;

  
    @GetMapping
    public ResponseEntity<List<TipoPagoEntity>> getAll() {
        List<TipoPagoEntity> list = service.getDataList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPagoEntity> getById(@PathVariable Long id) {
        TipoPagoEntity entity = service.getFindUncle(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }
}
