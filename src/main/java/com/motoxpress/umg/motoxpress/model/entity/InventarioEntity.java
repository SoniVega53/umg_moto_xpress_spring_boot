package com.motoxpress.umg.motoxpress.model.entity;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "INVENTARIO")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventarioEntity {

    @Id
    @Column(name = "id_inventario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne
    @JoinColumn(name = "id_motocicleta", nullable = false)
    private MotocicletaEntity motocicleta;

    @ManyToOne
    @JoinColumn(name = "id_zona", nullable = false)
    private ZonaGeograficaEntity zona;

    @Column(name = "fecha_disponibilidad", nullable = false)
    private Date fechaDisponibilidad;

  
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usuario_creo", nullable = false, length = 50)
    private String usuarioCreo;

    @Column(name = "usuario_modifico", length = 50)
    private String usuarioModifico;
    
}