package edu.uptc.parcialwebdilan.controller;
import edu.uptc.parcialwebdilan.entityes.customer;
import edu.uptc.parcialwebdilan.handling.ResponseHandler;
import edu.uptc.parcialwebdilan.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class customerController {
    @Autowired
    private customerService customerService;

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<Object> getCustomers() {
        try {
            List<customer> customers = customerService.getCustomers();
            return new ResponseHandler().generateResponse("Customers found", HttpStatus.OK, customers);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") long id) {
        try {
            customer customer = customerService.getCustomerById(id);
            if (customer == null) {
                return new ResponseHandler().generateResponse("Customer not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Customer found", HttpStatus.OK, customer);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Guardar un nuevo cliente
    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody customer customer) {
        try {
            customerService.saveCustomer(customer);
            return new ResponseHandler().generateResponse("Customer saved successfully", HttpStatus.CREATED, customer);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") long id, @RequestBody customer customer) {
        try {
            customer updatedCustomer = customerService.updateCustomer(id, customer);
            if (updatedCustomer == null) {
                return new ResponseHandler().generateResponse("Customer not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Customer updated successfully", HttpStatus.OK, updatedCustomer);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") long id) {
        try {
            boolean deleted = customerService.deleteCustomer(id);
            if (!deleted) {
                return new ResponseHandler().generateResponse("Customer not found", HttpStatus.NOT_FOUND, null);
            }
            return new ResponseHandler().generateResponse("Customer deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return new ResponseHandler().generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
