package org.una.tienda.facturacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import static org.aspectj.bridge.MessageUtil.fail;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.una.tienda.facturacion.dto.ProductoDTO;
import org.una.tienda.facturacion.services.IProductoService;

/**
 *
 * @author LordLalo
 */
@SpringBootTest
public class ProductoServiceImplementationTests {

    @Autowired
    private IProductoService productoService;

    ProductoDTO productoEjemplo;

    @BeforeEach
    public void setup() {
        productoEjemplo = new ProductoDTO() {
            {
                setDescripcion("Producto De Ejemplo");
                setImpuesto(0.10);
                setEstado(false);
                setFechaModificacion(Date.from(Instant.MIN));
                setFechaRegistro(Date.from(Instant.MIN));
    
            }
        };
    }

    @Test
    public void sePuedeCrearUnProductoCorrectamente() {
 
        productoEjemplo = productoService.create(productoEjemplo);

        Optional<ProductoDTO> productoEncontrado = productoService.findById(productoEjemplo.getId());

        if (productoEncontrado.isPresent()) {
            ProductoDTO producto = productoEncontrado.get();
            assertEquals(productoEjemplo.getId(), producto.getId());

        } else {
            fail("No se encontro la información en la BD");
        }
    }

    @AfterEach
    public void tearDown() {
        if (productoEjemplo != null) {
            productoService.delete(productoEjemplo.getId());
            productoEjemplo = null;
        }

    }

}
