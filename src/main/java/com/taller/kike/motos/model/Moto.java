package com.taller.kike.motos.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad que representa una motocicleta en el sistema.
 * Esta clase es la representación de la tabla 'motos' en la base de datos.
 */
@Data
@Entity
@Table(name = "motos")
public class Moto {
    /**
     * Identificador único de la motocicleta.
     * Se genera automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Marca de la motocicleta.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String marca;

    /**
     * Modelo de la motocicleta.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private String modelo;

    /**
     * Año de fabricación de la motocicleta.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private Integer anio;

    /**
     * Placa única de la motocicleta.
     * No puede ser nula y debe ser única en el sistema.
     */
    @Column(nullable = false, unique = true)
    private String placa;

    /**
     * Kilometraje actual de la motocicleta.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private Integer kilometraje;

    /**
     * Descripción adicional de la motocicleta.
     * Puede ser nula.
     */
    private String descripcion;

    /**
     * Estado de la motocicleta en el sistema.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private boolean activo;
}