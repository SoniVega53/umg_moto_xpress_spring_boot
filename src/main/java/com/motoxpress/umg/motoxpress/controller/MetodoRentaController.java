package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.motoxpress.umg.motoxpress.model.entity.MetodoRentaEntity;
import com.motoxpress.umg.motoxpress.service.MetodoRentaService;

@RestController
@RequestMapping("/proyecto/metodoRenta")
public class MetodoRentaController {

    @Autowired
    private MetodoRentaService metodoRentaService;

    @GetMapping
    public List<MetodoRentaEntity> getAllMetodosRenta() {
        return metodoRentaService.getDataList();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MetodoRentaEntity> getMetodoRentaById(@PathVariable Long id) {
        MetodoRentaEntity metodoRenta = metodoRentaService.getFindUncle(id);
        if (metodoRenta != null) {
            return ResponseEntity.ok(metodoRenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
