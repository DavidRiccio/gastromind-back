package com.gastromind.api.domain.ports.in;

import java.util.List;
import com.gastromind.api.domain.models.FridgeItem;

public interface IFridgeItemService {
    /**
     * Recupera todos los items de todas las neveras.
     */
    List<FridgeItem> findAll();

    /**
     * Busca un item específico por su ID único.
     */
    FridgeItem findById(String id);

    /**
     * Lista todos los productos contenidos en una nevera específica.
     */
    List<FridgeItem> findByFridgeId(String fridgeId);

    /**
     * Registra un nuevo item en la nevera (ej. tras un escaneo de ticket).
     */
    FridgeItem create(FridgeItem fridgeItem);

    /**
     * Actualiza un item existente (ideal para descontar unidades tras cocinar).
     */
    FridgeItem update(String id, FridgeItem fridgeItem);

    /**
     * Elimina un item (cuando se agota o se tira).
     */
    void delete(String id);
}