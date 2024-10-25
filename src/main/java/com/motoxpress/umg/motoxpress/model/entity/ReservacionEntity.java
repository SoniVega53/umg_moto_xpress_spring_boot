package com.motoxpress.umg.motoxpress.model.entity;
import java.sql.Date;

import java.util.List;
import java.util.Optional;

import com.motoxpress.umg.motoxpress.model.entity.Pagos.PagoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESERVACION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacion")
    private Long idReservacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UserEntity usuario;

    // @ManyToOne
    // @JoinColumn(name = "id_tipo_estado_reservacion", nullable = false)
    // private TipoEstadoReservacionEntity tipoEstadoReservacion;

    // @ManyToOne
    // @JoinColumn(name = "id_metodo_renta", nullable = false)
    // private MetodoRentaEntity metodoRenta;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private PagoEntity pago;

    // @ManyToOne
    // @JoinColumn(name = "id_inventario", nullable = false)
    // private InventarioEntity inventario;

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
