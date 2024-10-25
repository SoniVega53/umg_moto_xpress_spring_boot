package com.motoxpress.umg.motoxpress.model.entity;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSONA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "telefono", length = 100)
    private String telefono;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion", nullable = true)
    private Date fechaModificacion;

    @Column(name = "usuario_creo", length = 50, nullable = true)
    private String usuarioCreo;

    @Column(name = "usuario_modifico", length = 50, nullable = true)
    private String usuarioModifico;

}
