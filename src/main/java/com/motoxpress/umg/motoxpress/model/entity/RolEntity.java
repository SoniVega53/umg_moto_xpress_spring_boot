package com.motoxpress.umg.motoxpress.model.entity;
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

@Table(name = "ROL")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolEntity {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false)
    private String fecha_creacion;

    @Column(name = "fecha_modificacion", nullable = false)
    private String fecha_modificacion;

    @Column(name = "usuario_creo", nullable = false, length = 50)
    private String usuario_creo;

    @Column(name = "usuario_modifico", nullable = false, length = 50)
    private String usuario_modifico;
    
}