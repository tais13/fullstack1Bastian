package com.example.fiestaapp.repository;

import com.example.fiestaapp.model.Fiesta;

import jakarta.validation.Valid;

import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class FiestaRepository {

    private Map<Long, Fiesta> baseDatos = new HashMap<>();
    private Long contadorId = 1L;

    public Fiesta guardar(Fiesta fiesta) {
        fiesta.setId(contadorId++);
        baseDatos.put(fiesta.getId(), fiesta);
        return fiesta;
    }

    public List<Fiesta> obtenerTodas() {
        return new ArrayList<>(baseDatos.values());
    }

    public Optional<Fiesta> obtenerPorId(Long id) {
        return Optional.ofNullable(baseDatos.get(id));
    }

    public Fiesta actualizar(Long id, Fiesta fiesta) {
        fiesta.setId(id);
        baseDatos.put(id, fiesta);
        return fiesta;
    }

    public void eliminar(Long id) {
        baseDatos.remove(id);
    }
}