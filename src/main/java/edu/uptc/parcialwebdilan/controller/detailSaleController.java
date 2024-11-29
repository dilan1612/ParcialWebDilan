package edu.uptc.parcialwebdilan.controller;

import edu.uptc.parcialwebdilan.entityes.detailSale;
import edu.uptc.parcialwebdilan.handling.ResponseHandler;
import edu.uptc.parcialwebdilan.service.detailSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailsales")

public class detailSaleController {

    @Autowired
    private detailSaleService detailSaleService;

    // Obtener todos los detalles de venta
    @GetMapping
    public ResponseEntity<Object> getDetailSales() {
        try {
            List<detailSale> detailSales = detailSaleService.getDetailSales();
            return new ResponseHandler().generateResponse("Detail Sales found", HttpStatus.OK, detailSales);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Obtener un detalle de venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetailSale(@PathVariable("id") long id) {
        try {
            detailSale detailSale = detailSaleService.getDetailSaleById(id);
            if (detailSale == null) {
                return new ResponseHandler().generateResponse("Detail Sale not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Detail Sale found", HttpStatus.OK, detailSale);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Guardar un nuevo detalle de venta
    @PostMapping
    public ResponseEntity<Object> saveDetailSale(@RequestBody detailSale detailSale) {
        try {
            detailSaleService.saveDetailSale(detailSale);
            return new ResponseHandler().generateResponse("Detail Sale saved successfully", HttpStatus.CREATED, detailSale);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Actualizar un detalle de venta existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDetailSale(@PathVariable("id") long id, @RequestBody detailSale updatedDetailSale) {
        try {
            detailSale detailSale = detailSaleService.updateDetailSale(id, updatedDetailSale);
            if (detailSale == null) {
                return new ResponseHandler().generateResponse("Detail Sale not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Detail Sale updated successfully", HttpStatus.OK, detailSale);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Eliminar un detalle de venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDetailSale(@PathVariable("id") long id) {
        try {
            boolean deleted = detailSaleService.deleteDetailSale(id);
            if (!deleted) {
                return new ResponseHandler().generateResponse("Detail Sale not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Detail Sale deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
