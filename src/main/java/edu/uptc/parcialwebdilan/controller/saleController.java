package edu.uptc.parcialwebdilan.controller;


import edu.uptc.parcialwebdilan.entityes.sale;
import edu.uptc.parcialwebdilan.handling.ResponseHandler;
import edu.uptc.parcialwebdilan.service.saleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class saleController {

    @Autowired
    private saleService saleService;

    // Obtener todas las ventas
    @GetMapping
    public ResponseEntity<Object> getSales() {
        try {
            List<sale> sales = saleService.getSales();
            return new ResponseHandler().generateResponse("Sales found", HttpStatus.OK, sales);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Obtener una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getSale(@PathVariable("id") long id) {
        try {
            sale sale = saleService.getSaleById(id);
            if (sale == null) {
                return new ResponseHandler().generateResponse("Sale not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Sale found", HttpStatus.OK, sale);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Guardar una nueva venta
    @PostMapping
    public ResponseEntity<Object> saveSale(@RequestBody sale sale) {
        try {
            saleService.saveSale(sale);
            return new ResponseHandler().generateResponse("Sale saved successfully", HttpStatus.CREATED, sale);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Actualizar una venta existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSale(@PathVariable("id") long id, @RequestBody sale updatedSale) {
        try {
            sale sale = saleService.updateSale(id, updatedSale);
            if (sale == null) {
                return new ResponseHandler().generateResponse("Sale not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Sale updated successfully", HttpStatus.OK, sale);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable("id") long id) {
        try {
            boolean deleted = saleService.deleteSale(id);
            if (!deleted) {
                return new ResponseHandler().generateResponse("Sale not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Sale deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
