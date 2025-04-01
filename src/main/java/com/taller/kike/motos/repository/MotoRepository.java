package com.taller.kike.motos.repository;

import com.taller.kike.motos.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio para la entidad Moto.
 * Proporciona operaciones de base de datos para la entidad Moto.
 */
@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    /**
     * Busca una moto por su placa.
     */
    Optional<Moto> findByPlaca(String placa);

    /**
     * Busca motos por marca.
     */
    List<Moto> findByMarca(String marca);

    /**
     * Busca motos por modelo.
     */
    List<Moto> findByModelo(String modelo);

    /**
     * Busca motos por estado activo/inactivo.
     */
    List<Moto> findByActivo(boolean activo);
}