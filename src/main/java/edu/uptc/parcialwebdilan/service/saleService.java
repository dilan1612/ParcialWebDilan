package edu.uptc.parcialwebdilan.service;


import edu.uptc.parcialwebdilan.entityes.sale;
import edu.uptc.parcialwebdilan.repository.saleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class saleService {
    @Autowired
    private saleRepository saleRepository;

    public saleService() {}

    // Obtener todas las ventas
    public List<sale> getSales() {
        return saleRepository.findAll();
    }

    // Obtener una venta por ID
    public sale getSaleById(Long id) {
        Optional<sale> optionalSale = saleRepository.findById(id);
        return optionalSale.orElse(null);
    }

    // Guardar una nueva venta
    public void saveSale(sale sale) {
        saleRepository.save(sale);
    }

    // Actualizar una venta existente
    public sale updateSale(long id, sale updatedSale) {
        Optional<sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isPresent()) {
            sale sale = optionalSale.get();
            sale.setDate(updatedSale.getDate());
            sale.setTotal(updatedSale.getTotal());
            sale.setCustomer(updatedSale.getCustomer());
            return saleRepository.save(sale);
        }
        return null;
    }

    // Eliminar una venta
    public boolean deleteSale(long id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
