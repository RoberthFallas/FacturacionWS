/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.tienda.facturacion.entities.Cliente;
import org.una.tienda.facturacion.entities.ProductoExistencia;

/**
 *
 * @author LordLalo
 */
public interface IProductoExistenciaRepository extends JpaRepository<ProductoExistencia, Long> {
    
}
