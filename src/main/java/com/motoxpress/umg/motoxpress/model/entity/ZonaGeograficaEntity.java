package com.motoxpress.umg.motoxpress.model.entity;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ZONA_GEOGRAFICA")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZonaGeograficaEntity {

    @Id
    @Column(name = "id_zona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_zona", nullable = false, length = 50)
    private String nombre_zona;

    @Column(name = "codigo_postal", nullable = false, length = 50)
    private String codigo_postal;

    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Column(name = "ciudad", nullable = false, length = 50)
    private String ciudad;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = false)
    private Date fechaModificacion;

    @Column(name = "usuario_creo", nullable = false, length = 50)
    private String usuarioCreo;

    @Column(name = "usuario_modifico", nullable = false, length = 50)
    private String usuarioModifico;
    
}