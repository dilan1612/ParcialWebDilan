package edu.uptc.parcialwebdilan.controller;

import edu.uptc.parcialwebdilan.entityes.product;
import edu.uptc.parcialwebdilan.handling.ResponseHandler;
import edu.uptc.parcialwebdilan.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class productController {


    @Autowired
    private productService productService;

    // Obtener todos los productos
    @GetMapping
    public ResponseEntity<Object> getProducts() {
        try {
            List<product> products = productService.getProducts();
            return new ResponseHandler().generateResponse("Products found", HttpStatus.OK, products);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") long id) {
        try {
            product product = productService.getProductById(id);
            if (product == null) {
                return new ResponseHandler().generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Product found", HttpStatus.OK, product);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Guardar un nuevo producto
    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody product product) {
        try {
            productService.saveProduct(product);
            return new ResponseHandler().generateResponse("Product saved successfully", HttpStatus.CREATED, product);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") long id, @RequestBody product updatedProduct) {
        try {
            product product = productService.updateProduct(id, updatedProduct);
            if (product == null) {
                return new ResponseHandler().generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Product updated successfully", HttpStatus.OK, product);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") long id) {
        try {
            boolean deleted = productService.deleteProduct(id);
            if (!deleted) {
                return new ResponseHandler().generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Product deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
