package com.motoxpress.umg.motoxpress.model.entity.Pagos;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

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
@Table(name = "TIPO_PAGO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoPagoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago")
    private Long idTipoPago;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;

    @Column(name = "fecha_reservacion", nullable = false)
    private Date fechaReservacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usuario_creo", length = 50, nullable = false)
    private String usuarioCreo;

    @Column(name = "usuario_modifico", length = 50)
    private String usuarioModifico;

}
