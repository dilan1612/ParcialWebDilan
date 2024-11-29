package edu.uptc.parcialwebdilan.service;
import edu.uptc.parcialwebdilan.entityes.customer;
import edu.uptc.parcialwebdilan.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class customerService {

    @Autowired
    private customerRepository customerRepository;

    public customerService() {}

    // Obtener todos los clientes
    public List<customer> getCustomers() {
        return customerRepository.findAll();
    }

    // Obtener un cliente por ID
    public customer getCustomerById(Long id) {
        Optional<customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
    }

    // Guardar un nuevo cliente
    public void saveCustomer(customer customer) {
        customerRepository.save(customer);
    }

    // Actualizar un cliente existente
    public customer updateCustomer(long id, customer updatedCustomer) {
        Optional<customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customer customer = optionalCustomer.get();
            customer.setName(updatedCustomer.getName());
            customer.setMail(updatedCustomer.getMail());
            customer.setPhone(updatedCustomer.getPhone());
            return customerRepository.save(customer);
        }
        return null;
    }

    // Eliminar un cliente
    public boolean deleteCustomer(long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
