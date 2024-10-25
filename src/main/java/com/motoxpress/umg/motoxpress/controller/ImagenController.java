package com.motoxpress.umg.motoxpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.motoxpress.umg.motoxpress.model.entity.ImagenEntity;
import com.motoxpress.umg.motoxpress.service.ImagenService;

@RestController
@RequestMapping("/proyecto/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public List<ImagenEntity> getAllImagenes() {
        return imagenService.getDataList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagenEntity> getImagenById(@PathVariable Long id) {
        ImagenEntity imagen = imagenService.getFindUncle(id);
        if (imagen != null) {
            return ResponseEntity.ok(imagen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ImagenEntity createImagen(@RequestBody ImagenEntity imagen) {
        return imagenService.createOrUpdate(imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImagenEntity> updateImagen(@PathVariable Long id, @RequestBody ImagenEntity imagen) {
        ImagenEntity existingImagen = imagenService.getFindUncle(id);
        if (existingImagen != null) {
            imagen.setId(id);
            return ResponseEntity.ok(imagenService.createOrUpdate(imagen));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImagen(@PathVariable Long id) {
        ImagenEntity imagen = imagenService.getFindUncle(id);
        if (imagen != null) {
            imagenService.deleteFind(imagen);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
