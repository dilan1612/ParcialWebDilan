package edu.uptc.parcialwebdilan.service;


import edu.uptc.parcialwebdilan.entityes.product;
import edu.uptc.parcialwebdilan.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {
    @Autowired
    private productRepository productRepository;

    public productService() {}

    // Obtener todos los productos
    public List<product> getProducts() {
        return productRepository.findAll();
    }

    // Obtener un producto por ID
    public product getProductById(Long id) {
        Optional<product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // Guardar un nuevo producto
    public void saveProduct(product product) {
        productRepository.save(product);
    }

    // Actualizar un producto existente
    public product updateProduct(long id, product updatedProduct) {
        Optional<product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            product product = optionalProduct.get();
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            return productRepository.save(product);
        }
        return null;
    }

    // Eliminar un producto
    public boolean deleteProduct(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
