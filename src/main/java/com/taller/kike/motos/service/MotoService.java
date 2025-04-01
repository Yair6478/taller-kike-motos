package com.taller.kike.motos.service;

import com.taller.kike.motos.dto.MotoDTO;
import com.taller.kike.motos.mapper.MotoMapper;
import com.taller.kike.motos.model.Moto;
import com.taller.kike.motos.repository.MotoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Servicio que implementa la lógica de negocio para la gestión de motocicletas.
 * Esta clase actúa como intermediario entre el controlador y el repositorio.
 */
@Service
@RequiredArgsConstructor
public class MotoService {
    private final MotoRepository motoRepository;
    private final MotoMapper motoMapper;

    /**
     * Obtiene todas las motocicletas registradas en el sistema.
     * @return Lista de DTOs de motocicletas
     */
    @Transactional(readOnly = true)
    public List<MotoDTO> obtenerTodasLasMotos() {
        return motoMapper.toDtoList(motoRepository.findAll());
    }

    /**
     * Obtiene una motocicleta por su ID.
     * @param id ID de la motocicleta
     * @return DTO de la motocicleta
     * @throws EntityNotFoundException si la moto no existe
     */
    @Transactional(readOnly = true)
    public MotoDTO obtenerMotoPorId(Long id) {
        return motoRepository.findById(id)
                .map(motoMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Moto no encontrada con id: " + id));
    }

    /**
     * Crea una nueva motocicleta en el sistema.
     * @param motoDTO DTO con los datos de la motocicleta
     * @return DTO de la motocicleta creada
     * @throws IllegalArgumentException si ya existe una moto con la misma placa
     */
    @Transactional
    public MotoDTO crearMoto(MotoDTO motoDTO) {
        motoRepository.findByPlaca(motoDTO.getPlaca())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("Ya existe una moto con la placa: " + motoDTO.getPlaca());
                });
        return motoMapper.toDto(motoRepository.save(motoMapper.toEntity(motoDTO)));
    }

    /**
     * Actualiza una motocicleta existente.
     * @param id ID de la motocicleta a actualizar
     * @param motoDTO DTO con los nuevos datos
     * @return DTO de la motocicleta actualizada
     * @throws EntityNotFoundException si la moto no existe
     */
    @Transactional
    public MotoDTO actualizarMoto(Long id, MotoDTO motoDTO) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto no encontrada con id: " + id));

        moto.setMarca(motoDTO.getMarca());
        moto.setModelo(motoDTO.getModelo());
        moto.setAnio(motoDTO.getAnio());
        moto.setKilometraje(motoDTO.getKilometraje());
        moto.setDescripcion(motoDTO.getDescripcion());
        moto.setActivo(motoDTO.isActivo());

        return motoMapper.toDto(motoRepository.save(moto));
    }

    /**
     * Elimina una motocicleta del sistema.
     * @param id ID de la motocicleta a eliminar
     * @throws EntityNotFoundException si la moto no existe
     */
    @Transactional
    public void eliminarMoto(Long id) {
        if (!motoRepository.existsById(id)) {
            throw new EntityNotFoundException("Moto no encontrada con id: " + id);
        }
        motoRepository.deleteById(id);
    }

    /**
     * Busca motocicletas por marca.
     * @param marca Marca a buscar
     * @return Lista de DTOs de motocicletas que coinciden con la marca
     */
    @Transactional(readOnly = true)
    public List<MotoDTO> obtenerMotosPorMarca(String marca) {
        return motoMapper.toDtoList(motoRepository.findByMarca(marca));
    }

    /**
     * Busca motocicletas por modelo.
     * @param modelo Modelo a buscar
     * @return Lista de DTOs de motocicletas que coinciden con el modelo
     */
    @Transactional(readOnly = true)
    public List<MotoDTO> obtenerMotosPorModelo(String modelo) {
        return motoMapper.toDtoList(motoRepository.findByModelo(modelo));
    }

    /**
     * Busca motocicletas por estado activo/inactivo.
     * @param activo Estado a buscar
     * @return Lista de DTOs de motocicletas que coinciden con el estado
     */
    @Transactional(readOnly = true)
    public List<MotoDTO> obtenerMotosPorEstado(boolean activo) {
        return motoMapper.toDtoList(motoRepository.findByActivo(activo));
    }
}