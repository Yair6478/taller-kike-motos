package com.taller.kike.motos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/**
 * Clase DTO (Data Transfer Object) para la entidad Moto.
 * Se utiliza para transferir datos entre la capa de presentación y la capa de servicio.
 */
@Data
public class MotoDTO {
    private Long id;

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @NotNull(message = "El año es obligatorio")
    @Positive(message = "El año debe ser positivo")
    private Integer anio;

    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    @NotNull(message = "El kilometraje es obligatorio")
    @Positive(message = "El kilometraje debe ser positivo")
    private Integer kilometraje;

    private String descripcion;

    private boolean activo;
}