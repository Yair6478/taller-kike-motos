package com.taller.kike.motos.controller;

import com.taller.kike.motos.dto.MotoDTO;
import com.taller.kike.motos.service.MotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD para motocicletas.
 * Proporciona endpoints para gestionar motocicletas en el sistema.
 */
@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
@CrossOrigin
public class MotoController {
    private final MotoService motoService;

    /**
     * Obtiene todas las motocicletas.
     * @return ResponseEntity con la lista de motocicletas
     */
    @GetMapping
    public ResponseEntity<List<MotoDTO>> obtenerTodasLasMotos() {
        return ResponseEntity.ok(motoService.obtenerTodasLasMotos());
    }

    /**
     * Obtiene una motocicleta por su ID.
     * @param id ID de la motocicleta
     * @return ResponseEntity con la motocicleta encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> obtenerMotoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.obtenerMotoPorId(id));
    }

    /**
     * Crea una nueva motocicleta.
     * @param motoDTO DTO con los datos de la motocicleta
     * @return ResponseEntity con la motocicleta creada
     */
    @PostMapping
    public ResponseEntity<MotoDTO> crearMoto(@Valid @RequestBody MotoDTO motoDTO) {
        return new ResponseEntity<>(motoService.crearMoto(motoDTO), HttpStatus.CREATED);
    }

    /**
     * Actualiza una motocicleta existente.
     * @param id ID de la motocicleta a actualizar
     * @param motoDTO DTO con los nuevos datos
     * @return ResponseEntity con la motocicleta actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> actualizarMoto(@PathVariable Long id, @Valid @RequestBody MotoDTO motoDTO) {
        return ResponseEntity.ok(motoService.actualizarMoto(id, motoDTO));
    }

    /**
     * Elimina una motocicleta.
     * @param id ID de la motocicleta a eliminar
     * @return ResponseEntity sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMoto(@PathVariable Long id) {
        motoService.eliminarMoto(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Busca motocicletas por marca.
     * @param marca Marca a buscar
     * @return ResponseEntity con la lista de motocicletas encontradas
     */
    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<MotoDTO>> obtenerMotosPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(motoService.obtenerMotosPorMarca(marca));
    }

    /**
     * Busca motocicletas por modelo.
     * @param modelo Modelo a buscar
     * @return ResponseEntity con la lista de motocicletas encontradas
     */
    @GetMapping("/modelo/{modelo}")
    public ResponseEntity<List<MotoDTO>> obtenerMotosPorModelo(@PathVariable String modelo) {
        return ResponseEntity.ok(motoService.obtenerMotosPorModelo(modelo));
    }

    /**
     * Busca motocicletas por estado.
     * @param activo Estado a buscar
     * @return ResponseEntity con la lista de motocicletas encontradas
     */
    @GetMapping("/estado/{activo}")
    public ResponseEntity<List<MotoDTO>> obtenerMotosPorEstado(@PathVariable boolean activo) {
        return ResponseEntity.ok(motoService.obtenerMotosPorEstado(activo));
    }
}