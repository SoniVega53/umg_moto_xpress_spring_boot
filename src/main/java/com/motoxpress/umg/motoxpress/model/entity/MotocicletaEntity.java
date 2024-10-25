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
public class MotocicletaEntity {

    @Id
    @Column(name = "id_motocicleta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcaModeloEntity marca;

    @ManyToOne
    @JoinColumn(name = "id_estado_motocicleta", nullable = false)
    private TipoEstadoMotocicletaEntity estado;

    @Column(name = "kilometraje", nullable = false)
    private Integer kilometraje;

    @Column(name = "cilindraje", nullable = false, length = 50)
    private String cilindraje;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

  
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usuario_creo", nullable = false, length = 50)
    private String usuarioCreo;

    @Column(name = "usuario_modifico", length = 50)
    private String usuarioModifico;
    
}