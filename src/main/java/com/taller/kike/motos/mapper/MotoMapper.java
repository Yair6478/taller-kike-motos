package com.taller.kike.motos.mapper;

import com.taller.kike.motos.dto.MotoDTO;
import com.taller.kike.motos.model.Moto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Interfaz para mapear entre la entidad Moto y su DTO.
 * Utiliza MapStruct para generar automáticamente la implementación.
 */
@Mapper(componentModel = "spring")
public interface MotoMapper {
    /**
     * Convierte una entidad Moto a MotoDTO.
     */
    MotoDTO toDto(Moto moto);

    /**
     * Convierte un MotoDTO a entidad Moto.
     */
    Moto toEntity(MotoDTO dto);

    /**
     * Convierte una lista de entidades Moto a lista de MotoDTO.
     */
    List<MotoDTO> toDtoList(List<Moto> motos);
}