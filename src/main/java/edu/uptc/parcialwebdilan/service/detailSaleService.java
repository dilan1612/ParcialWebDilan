package edu.uptc.parcialwebdilan.service;

import edu.uptc.parcialwebdilan.entityes.detailSale;
import edu.uptc.parcialwebdilan.repository.detailSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class detailSaleService {

    @Autowired
    private detailSaleRepository detailSaleRepository;

    public detailSaleService() {}

    // Obtener todos los detalles de venta
    public List<detailSale> getDetailSales() {
        return detailSaleRepository.findAll();
    }

    // Obtener un detalle de venta por ID
    public detailSale getDetailSaleById(Long id) {
        Optional<detailSale> optionalDetailSale = detailSaleRepository.findById(id);
        return optionalDetailSale.orElse(null);
    }

    // Guardar un nuevo detalle de venta
    public void saveDetailSale(detailSale detailSale) {
        detailSaleRepository.save(detailSale);
    }

    // Actualizar un detalle de venta existente
    public detailSale updateDetailSale(long id, detailSale updatedDetailSale) {
        Optional<detailSale> optionalDetailSale = detailSaleRepository.findById(id);
        if (optionalDetailSale.isPresent()) {
            detailSale detailSale = optionalDetailSale.get();
            detailSale.setQuantity(updatedDetailSale.getQuantity());
            detailSale.setSubtotal(updatedDetailSale.getSubtotal());
            detailSale.setProduct(updatedDetailSale.getProduct());
            detailSale.setSale(updatedDetailSale.getSale());
            return detailSaleRepository.save(detailSale);
        }
        return null;
    }

    // Eliminar un detalle de venta
    public boolean deleteDetailSale(long id) {
        if (detailSaleRepository.existsById(id)) {
            detailSaleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
